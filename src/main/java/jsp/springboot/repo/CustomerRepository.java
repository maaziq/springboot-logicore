package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
