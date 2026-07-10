package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Payment;
import jsp.springboot.enums.PaymentStatus;
import jsp.springboot.service.PaymentService;

@RequestMapping("/payment")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayment(){
		
		return new ResponseEntity<>(paymentService.getAllPayment(), HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Payment>> getById(@PathVariable Integer id){
		
		return new ResponseEntity<>(paymentService.getIdByPayment(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/method/{id}/{status}")
	public ResponseEntity<ResponseStructure<Payment>> updatePaymentMethod(@PathVariable Integer id, @PathVariable PaymentStatus status){
		
		return new ResponseEntity<>(paymentService.updatePaymentMethod(id, status), HttpStatus.OK);
	}

}
