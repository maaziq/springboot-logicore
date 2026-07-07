package jsp.springboot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.DeliveryAgent;

public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer> {
	
	Optional<DeliveryAgent> findByAgentContact(Long contact);
	
	Optional<DeliveryAgent> findByVehicleNumber(String vehicleNumber);
	
	List<DeliveryAgent> findByRatingGreaterThan(Integer rating);

}
