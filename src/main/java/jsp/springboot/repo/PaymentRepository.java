package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
