package jsp.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jsp.springboot.enums.TrackingStatus;

@Entity
public class TrackingHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String location;
	private String remark;
	
	@Enumerated(EnumType.STRING)
	private TrackingStatus status;
	
	@ManyToOne
	@JoinColumn(name = "shipment_id")
	@JsonBackReference
	private Shipment shipment;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public TrackingStatus getStatus() {
		return status;
	}

	public void setStatus(TrackingStatus status) {
		this.status = status;
	}
	
	public Shipment getShipment() {
	    return shipment;
	}

	public void setShipment(Shipment shipment) {
	    this.shipment = shipment;
	}
	
}
