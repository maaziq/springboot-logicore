package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Customer;
import jsp.springboot.service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> createCustomer(@RequestBody Customer customer){
		
		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> findById(@PathVariable Integer id){
		
		return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseStructure<Customer>> findByEmail(@PathVariable String email){
		
		return new ResponseEntity<>(customerService.findByEmail(email), HttpStatus.OK);
	}
	
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<ResponseStructure<Customer>> findByContact(@PathVariable Long contact){
		
		return new ResponseEntity<>(customerService.findByContact(contact), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer){
		
		return new ResponseEntity<>(customerService.UpdateCustomer(customer), HttpStatus.OK);
	}
	
	
	@GetMapping("/page/{pn}/{ps}/{field}")
	public ResponseEntity<ResponseStructure<Page<Customer>>> getByPagination(@PathVariable Integer pn, @PathVariable Integer ps, @PathVariable String field){
		
		return new ResponseEntity<>(customerService.getByPaginationAndSorting(pn, ps, field), HttpStatus.OK);
	}
	
}




