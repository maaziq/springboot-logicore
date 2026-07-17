package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Customer;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
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
	
	
	public ResponseStructure<Customer> findByEmail(String email){
		
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Optional<Customer> opt = customerRepository.findByEmail(email);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching customer by email");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new NoRecordFoundException("No record found by email");
	}
	
	
	public ResponseStructure<Customer> findByContact(Long contact){
		
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Optional<Customer> opt = customerRepository.findByContact(contact);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching customer by contact");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new NoRecordFoundException("No record found by email");
	} 
	
	
	public ResponseStructure<Customer> UpdateCustomer(Customer customer){
		
		ResponseStructure<Customer> res = new ResponseStructure<>();
		
		if(customer.getId()==null)
			throw new IdNotFoundException("Id not found in the db");
		
		Optional<Customer> opt = customerRepository.findById(customer.getId());
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("customer updated sucessfully!");
			res.setData(customerRepository.save(customer));
			
			return res;
		}
		else 
			throw new NoRecordFoundException("No record found in the db");
	}
	
	
	public ResponseStructure<Page<Customer>> getByPaginationAndSorting(Integer pn, Integer ps, String field){
		
		ResponseStructure<Page<Customer>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching by paginationa and sorting");
		res.setData(customerRepository.findAll(PageRequest.of(pn, ps, Sort.by(field).ascending())));
		
		return res;
	}
	
}











