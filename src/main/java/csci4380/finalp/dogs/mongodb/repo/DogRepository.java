/**
 * 
 */
package csci4380.finalp.dogs.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import csci4380.finalp.dogs.mongodb.model.Dog;


/**
 * @author stajekankati
 *
 */
@Repository
public interface DogRepository extends MongoRepository<Dog, String> {
	// NOTE ilker, below are examples of using "Generated Query Methods" following convention of Spring Data (same thing with Spring Data JPA)
	public Optional<List<Dog>> findByPetId(Integer petId);
	public Optional<List<Dog>> findByNameOrOwnerName(String name, String ownerName);
	public void deleteByPetId(String petId);
	
	@Query
	public Dog findByTypeIgnoreCase(@Param("type") String type);
	@Query("{'type': ?0}")
	public List<Dog> findMyByType(String type);
	

}
