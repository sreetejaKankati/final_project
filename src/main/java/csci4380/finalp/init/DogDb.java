/**
 * 
 */
package csci4380.finalp.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.dogs.mongodb.model.Dog;
import csci4380.finalp.dogs.mongodb.repo.DogRepository;

/**
 * @author stajekankati
 *
 */
public class DogDb {
	@Component
	public class InitDogDb implements CommandLineRunner
	{
	private DogRepository dogRepository;

	public InitDogDb(DogRepository dogRepository)
	{
	this.dogRepository = dogRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
	Dog dogOne = new Dog (null, 169, "Ace", "German Sheperd", "Staje", "1 Fortnite Road", 5, false, "05/22/2013");
	Dog dogTwo = new Dog (null, 625, "Spike", "Lab", "Sidd", "55 TiltedTower Road", 4, true, "11/11/2014");

	List<Dog> dogs = Arrays.asList(dogOne, dogTwo);
	dogRepository.saveAll(dogs);

	}
	}

}
