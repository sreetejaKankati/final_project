/**
 * 
 */
package csci4380.finalp.dogs.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csci4380.finalp.dogs.mongodb.model.Dog;
import csci4380.finalp.dogs.mongodb.repo.DogRepository;

/**
 * @author stajekankati
 *
 */
@RestController
@RequestMapping("rest/v1/dogs")
public class DogRestController {

	private DogRepository dogRepository;

	// NOTE ilker turns out, we don't even need to put "@Autowired" here for
	// "Constructor injection". Spring does it even without it
	public DogRestController(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}

	@GetMapping("/echoMessage")
	/**
	 * curl -i http://localhost:8888/rest/v1/dogs/echoMessage?msg=Hi
	 */
	public String echoMessage(@RequestParam(value = "msg", defaultValue = "Hello Staje") String message) {
		return "echoMessage echoes: " + message;
	}

	@GetMapping("")
	public Page<Dog> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(value = "rowsPerPage", defaultValue = "3") int size) {
		Page<Dog> dogsPage = dogRepository.findAll(new PageRequest(page, size));
		return dogsPage;
	}

	// curl -i http://localhost:8888/rest/v1/teachers/all
	@GetMapping("/all")
	public List<Dog> findAll() {
		List<Dog> dogs = dogRepository.findAll();
		return dogs;
	}

	@PostMapping("")
	/**
	 * NOTE "save" is basically upsert. If teacher is not there in DB, it INSERTs.
	 * If dog is there in DB it UPDATEs
	 * 
	 * @param dog
	 * @return
	 */
	public Optional<Dog> save(@RequestBody final Dog dog) {
		Dog savedDog = dogRepository.save(dog);
		return dogRepository.findById(savedDog.getId());
	}

	@PutMapping("")
	public Dog insert(@RequestBody final Dog dog) {
		Dog insertedDog = dogRepository.insert(dog);
		return insertedDog;
	}

	// curl -i http://localhost:8888/rest/v1/teachers/5ad912c13eb4f729184980c1
	@GetMapping("/{id}")
	public Optional<Dog> findById(@PathVariable String id) {
		Optional<Dog> dog = dogRepository.findById(id);
		return dog;
	}

	// curl -i http://localhost:8888/rest/v1/teachers/teacherId/1
	@GetMapping("/petId/{petId}")
	public Optional<List<Dog>> findByPetId(@PathVariable Integer petId) {
		Optional<List<Dog>> dogs = dogRepository.findByPetId(petId);
		return dogs;

	}
}
