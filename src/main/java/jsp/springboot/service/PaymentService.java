package jsp.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Payment;
import jsp.springboot.enums.PaymentStatus;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.repo.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public ResponseStructure<List<Payment>> getAllPayment(){
		
		ResponseStructure<List<Payment>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all payyment from db");
		res.setData(paymentRepository.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<Payment> getIdByPayment(Integer id){
		
		ResponseStructure<Payment> res = new ResponseStructure<>();
		Optional<Payment> opt = paymentRepository.findById(id);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching  Payment by id!!");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new IdNotFoundException("Id not found ");
	}
	
	
	public ResponseStructure<Payment> updatePaymentMethod(Integer id, PaymentStatus status){
		
		ResponseStructure<Payment> res = new ResponseStructure<>();
		Optional<Payment> opt = paymentRepository.findById(id);
		
		
		if(opt.isPresent()) {
		Payment payment = opt.get();
		payment.setPaymentStatus(status);
		Payment updatePayment = paymentRepository.save(payment);
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(updatePayment);
		res.setMessage("Payment method updated sucessfully");
		
		return res;
		
		}
		else
			throw new IdNotFoundException("Id is not avialable");
	}
	
	
	public ResponseStructure<Payment> cancelPayment(Integer id) {

	    ResponseStructure<Payment> response = new ResponseStructure<>();

	    Optional<Payment> optional = paymentRepository.findById(id);

	    if (optional.isPresent()) {

	        Payment payment = optional.get();

	        if (payment.getPaymentStatus() == PaymentStatus.SUCCESS) {
	            throw new IllegalStateException("Successful payment cannot be cancelled.");
	        }

	        payment.setPaymentStatus(PaymentStatus.CANCELLED);

	        paymentRepository.save(payment);

	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Payment cancelled successfully");
	        response.setData(payment);

	        return response;
	    }

	    throw new IdNotFoundException("Payment id not found");
	}
	
	
}
