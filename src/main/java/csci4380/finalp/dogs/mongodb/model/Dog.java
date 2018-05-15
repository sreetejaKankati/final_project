/**
 * 
 */
package csci4380.finalp.dogs.mongodb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author stajekankati
 *
 */
@Document(collection="Dog")
public class Dog {
	@Id
	private String id;
	private Integer petId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String name;
	private String type;
	private String ownerName;
	private String address;
	private Integer age;
	private Boolean isSprayed;
	private String birthdate;
	
	public Dog() {}
	
	public Dog(String id, Integer petId, String name, String type, String ownerName, String address, Integer age,
			Boolean isSprayed, String birthdate) {
		super();
		this.id = id;
		this.petId = petId;
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.age = age;
		this.isSprayed = isSprayed;
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", petId=" + petId + ", name=" + name + ", type=" + type + ", ownerName=" + ownerName
				+ ", address=" + address + ", age=" + age + ", isSprayed=" + isSprayed + ", birthdate=" + birthdate
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsSprayed() {
		return isSprayed;
	}

	public void setIsSprayed(Boolean isSprayed) {
		this.isSprayed = isSprayed;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	} 
	
}
