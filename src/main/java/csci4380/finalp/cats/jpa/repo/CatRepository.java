/**
 * 
 */
package csci4380.finalp.cats.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import csci4380.finalp.cats.jpa.model.Cat;

/**
 * @author stajekankati
 *
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {

	public Optional<List<Cat>> findMyByNameOrOwnerName(String name, String ownerName);
	public void deleteByPetId(Integer petId);
	public Cat findByTypeIgnoreCase(@Param("type")String type);

}
