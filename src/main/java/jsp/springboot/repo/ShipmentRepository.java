package jsp.springboot.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	Optional<Shipment> findByTrackingNumber(Long trackingNumber);

	
}
 