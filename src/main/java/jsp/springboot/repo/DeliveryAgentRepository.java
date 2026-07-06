package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.DeliveryAgent;

public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer> {

}
