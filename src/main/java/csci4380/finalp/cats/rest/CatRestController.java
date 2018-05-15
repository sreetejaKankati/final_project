/**
 * 
 */
package csci4380.finalp.cats.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;









/**
 * @author stajekankati
 *
 */
@RestController
@RequestMapping("rest/v1/cats")
public class CatRestController {
	@Autowired CatRepository catRepository;
	@RequestMapping("/echoMessage")
	public String echoMessage(@RequestParam(value="msg", defaultValue="Staje Kankati") String message) {
		return "echoMessage echoes: " + message;
	}
	@GetMapping("")
	public Page<Cat> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage" , defaultValue="5") int size) {
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
	return catsPage;
	}

	@GetMapping("/all")
	public  List<Cat> findAll() {
		List<Cat> students = catRepository.findAll();
		return students;
	}
	
	@PostMapping("")
	public  Optional<Cat> save(@RequestBody final Cat cat) {
		Cat savedCat = catRepository.save(cat);
		return catRepository.findById(savedCat.getPetId());
	}
	
	@PutMapping("")
	public  Cat insert(@RequestBody final Cat cat) {
		Cat insertedCat = catRepository.save(cat);
		return insertedCat;
	}
	
	@GetMapping("/{petId}")
	public  Optional <Cat> findByPetId(@PathVariable Integer petId) {
		Optional<Cat> cat = catRepository.findById(petId);
		return cat;
	}
	
	@DeleteMapping("/{id}")
	public  void delete(@PathVariable("id") Integer petId) {
		catRepository.deleteByPetId(petId);
	}
	@GetMapping("/byNameOrOwnerName/{name}/{ownerName")
	public Optional<List<Cat>> findMyByNameOrOwnerName(@PathVariable String name, @PathVariable String ownerName) {
		Optional<List<Cat>> cats = catRepository.findMyByNameOrOwnerName(name,ownerName);
		return cats;
	}
	@GetMapping("//byTypeIgnoreCase/{type}")
	public  Cat findByNameIgnoreCaseQuery(@PathVariable String type) {
		Cat student = catRepository.findByTypeIgnoreCase(type);
		return student;
	}
	
}

