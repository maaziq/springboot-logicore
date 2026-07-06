package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.PackageEntity;

public interface PackageEntityRepository extends JpaRepository<PackageEntity, Integer>{

}
