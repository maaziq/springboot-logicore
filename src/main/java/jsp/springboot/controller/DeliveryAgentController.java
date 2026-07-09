package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.DeliveryAgent;
import jsp.springboot.service.DeliveryAgentService;

@RequestMapping("/agent")
@RestController
public class DeliveryAgentController {

	@Autowired
	private DeliveryAgentService deliveryAgentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<DeliveryAgent>> createAgent(@RequestBody DeliveryAgent deliveryAgent){
		
		return new ResponseEntity<>(deliveryAgentService.createAgent(deliveryAgent), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<DeliveryAgent>>> findAllAgents(){
		
		return new ResponseEntity<>(deliveryAgentService.getAllAgents(), HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<DeliveryAgent>> findById(@PathVariable Integer id){
		
		return new ResponseEntity<>(deliveryAgentService.getById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<ResponseStructure<DeliveryAgent>> findByContact(@PathVariable Long contact){
		
		return new ResponseEntity<>(deliveryAgentService.getByContact(contact), HttpStatus.OK);
	}
	
	
	@GetMapping("/vehicle/{num}")
	public ResponseEntity<ResponseStructure<DeliveryAgent>> findByVehicleNum(@PathVariable String num){
		
		return new ResponseEntity<>(deliveryAgentService.getByVehicleNum(num), HttpStatus.OK);
	}
	
	
	@GetMapping("/rating/{rating}")
	public ResponseEntity<ResponseStructure<List<DeliveryAgent>>> findByRating(@PathVariable Integer rating){
		
		return new ResponseEntity<>(deliveryAgentService.getByRatingGreater(rating), HttpStatus.OK);
	}
	
	
	@PutMapping()
	public ResponseEntity<ResponseStructure<DeliveryAgent>> updateAgent(@RequestBody DeliveryAgent deliveryAgent){
		
		return new ResponseEntity<>(deliveryAgentService.updateAgent(deliveryAgent), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAgent(@PathVariable Integer id){
		
		return new ResponseEntity<>(deliveryAgentService.deleteAgent(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}/{avialablity}")
	public ResponseEntity<ResponseStructure<DeliveryAgent>> updateAgentAvialablity(@PathVariable Integer id, @PathVariable Boolean avialablity){
		
		return new ResponseEntity<>(deliveryAgentService.updateAgentAvability(id, avialablity), HttpStatus.OK);
	}
	
}
