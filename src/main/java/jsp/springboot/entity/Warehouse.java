package jsp.springboot.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String wareName;
	private String location;
	private Long capacity;
	@Column(unique = true)
	private Long wareContact;
	
	// one to many mapping with the Shipment to be inducted
	@OneToMany(mappedBy = "warehouse")
	private List<Shipment> shipments;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public Long getWareContact() {
		return wareContact;
	}
	public void setWareContact(Long wareContact) {
		this.wareContact = wareContact;
	}
	
	
	

}
