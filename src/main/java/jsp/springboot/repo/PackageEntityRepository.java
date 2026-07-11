package jsp.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.PackageEntity;

public interface PackageEntityRepository extends JpaRepository<PackageEntity, Integer>{

	 Optional<PackageEntity> findByShipmentId(Integer shipmentId);
}
