package jsp.springboot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

	Optional<Warehouse> findByLocation(String location);
	
	List<Warehouse> findByCapacityGreaterThan(Long capacity);
}
