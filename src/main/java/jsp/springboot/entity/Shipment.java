package jsp.springboot.entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jsp.springboot.enums.ShipmentStatus;

@Entity
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private Long trackingNumber;
	private String source;
	private String destination;
	private Double weight;
	@CreationTimestamp
	private LocalDateTime shipmentDate;
	@CreationTimestamp
	private Date deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private ShipmentStatus shipmentStatus;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;

	@ManyToOne
	@JoinColumn(name = "delivery_agent_id")
	private DeliveryAgent deliveryAgent;

	@OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonManagedReference
	private PackageEntity packageEntity;

	@OneToOne(mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Payment payment;

	
	@OneToMany(mappedBy = "shipment")
	@JsonBackReference
	private List<TrackingHistory> trackingHistory;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Long getTrackingNumber() {
		return trackingNumber;
	}
	
	public void setTrackingNumber(Long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public LocalDateTime getShipmentDate() {
		return shipmentDate;
	}
	
	public void setShipmentDate(LocalDateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}
	
	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}
	
	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public PackageEntity getPackageEntity() {
		return packageEntity;
	}
	
	public void setPackageEntity(PackageEntity packageEntity) {
		this.packageEntity = packageEntity;
	}
	
	public List<TrackingHistory> getTrackingHistory() {
		return trackingHistory;
	}
	
	public void setTrackingHistory(List<TrackingHistory> trackingHistory) {
		this.trackingHistory = trackingHistory;
	}
	
	
	
}
