package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import jsp.springboot.entity.Shipment;
import jsp.springboot.enums.ShipmentStatus;
import jsp.springboot.service.ShipmentService;

@RequestMapping("/shipment")
@RestController
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Shipment>> createShipment(@RequestBody Shipment shipment){
		
		return new ResponseEntity<>(shipmentService.createShipment(shipment), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Shipment>> getById(@PathVariable Integer id){
		
		return new ResponseEntity<>(shipmentService.getById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getAll(){
		
		return new ResponseEntity<>(shipmentService.getAllShipment(), HttpStatus.OK);
	}
	
	
	@GetMapping("/tracking/{tracking}")
	public ResponseEntity<ResponseStructure<Shipment>> getByTrackingNum(@PathVariable Long tracking){
		
		return new ResponseEntity<>(shipmentService.getByTrackingNum(tracking), HttpStatus.OK);
	}
	
	
	@PutMapping("/status/{id}/{status}")
	public ResponseEntity<ResponseStructure<Shipment>> updateStatus(@PathVariable Integer id, @PathVariable ShipmentStatus status){
		
		return new ResponseEntity<>(shipmentService.updateStatus(id, status), HttpStatus.OK);
	}
	
} 

