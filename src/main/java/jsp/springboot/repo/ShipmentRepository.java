package jsp.springboot.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Customer;
import jsp.springboot.entity.DeliveryAgent;
import jsp.springboot.entity.Shipment;
import jsp.springboot.entity.Warehouse;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	Optional<Shipment> findByTrackingNumber(Long trackingNumber);
	
	List<Shipment> findByCustomer(Customer customer);
	
	List<Shipment> findByWarehouse(Warehouse warehouse);
	
	List<Shipment> findByDeliveryAgent(DeliveryAgent deliveryAgent);
	
	List<Shipment> findBySourceAndDestination(String source, String destination);
	
}
 