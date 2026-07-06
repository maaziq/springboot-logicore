package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

}
