package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

}
