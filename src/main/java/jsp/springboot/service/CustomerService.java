package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Customer;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public ResponseStructure<Customer> saveCustomer(Customer customer){
		
		ResponseStructure<Customer> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setMessage("Customer created sucessfully!!");
		res.setData(customerRepository.save(customer));
		
		return res;
	}
	
	
	public ResponseStructure<List<Customer>> getAllCustomers(){
		
		ResponseStructure<List<Customer>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all the customers from the db");
		res.setData(customerRepository.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<Customer> findById(Integer id){
		
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Optional<Customer> opt = customerRepository.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching customer by id from db");
			res.setData(opt.get());
			
			return res;
		}
		else {
			throw new IdNotFoundException("Id not found in the db");
		}
	}
	
	
	
}
