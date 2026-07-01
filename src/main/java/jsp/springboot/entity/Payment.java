package jsp.springboot.entity;

import java.time.DateTimeException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jsp.springboot.enums.PaymentMethod;
import jsp.springboot.enums.PaymentStatus;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	private Double amount;
	private PaymentMethod paymentMethod;
	private PaymentStatus paymentStatus;
	
}
