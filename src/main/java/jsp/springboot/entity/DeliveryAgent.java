package jsp.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeliveryAgent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer agentId;
	
	private String agentName;
	@Column(unique = true)
	private Long agentContact;
	@Column(unique = true)
	private String vehicleNumber;
	private Boolean avialability;
	private Integer rating;
	
	// one to many relationship with the shipment to be included
	
	
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Long getAgentContact() {
		return agentContact;
	}
	public void setAgentContact(Long agentContact) {
		this.agentContact = agentContact;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Boolean getAvialability() {
		return avialability;
	}
	public void setAvialability(Boolean avialability) {
		this.avialability = avialability;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	

}
