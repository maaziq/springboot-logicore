package jsp.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jsp.springboot.enums.PackageType;

@Entity
public class PackageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private PackageType packageType;
	
	private Boolean fragile;
	private String dimention;
	
	@OneToOne
	@JoinColumn(name = "shipment_id")
	private Shipment shipment;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PackageType getPackageType() {
		return packageType;
	}
	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}
	public Boolean getFragile() {
		return fragile;
	}
	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}
	public String getDimention() {
		return dimention;
	}
	public void setDimention(String dimention) {
		this.dimention = dimention;
	}
	public Shipment getShipment() {
	    return shipment;
	}

	public void setShipment(Shipment shipment) {
	    this.shipment = shipment;
	}
	
	
}
