package jsp.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	
	@PutMapping("/agent/{shipmentId}/{agentId}")
	public ResponseEntity<ResponseStructure<Shipment>> updateAgent(@PathVariable Integer shipmentId, @PathVariable Integer agentId){
		
		return new ResponseEntity<>(shipmentService.assignedDeliveryAgent(shipmentId, agentId), HttpStatus.OK);
	}
	
	
	@PutMapping("/warehouse/{shipmentId}/{warehouseId}")
	public ResponseEntity<ResponseStructure<Shipment>> updateWarehouse(@PathVariable Integer shipmentId, @PathVariable Integer warehouseId){
		
		return new ResponseEntity<>(shipmentService.assignedWarehouse(shipmentId, warehouseId), HttpStatus.OK);
	}
	
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteShipment(@PathVariable Integer id){
		
		return new ResponseEntity<ResponseStructure<String>>(shipmentService.deleteShipment(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getShipmentOfCustomer(@PathVariable Integer customerId){
		
		return new ResponseEntity<>(shipmentService.getShipmentOfCustomer(customerId), HttpStatus.OK);
	}
	
	
	@GetMapping("/warehouse/{warehouseId}")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getShipmentOfWarehouse(@PathVariable Integer warehouseId){
		
		return new ResponseEntity<>(shipmentService.getShipmentOfWarehouse(warehouseId), HttpStatus.OK);
	}
	
	
	@GetMapping("/delivery/{agentId}")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getShipmentAssignedToDeliveryAgent(@PathVariable Integer agentId){
		
		return new ResponseEntity<>(shipmentService.getShipmentAssignedDeliveryAgent(agentId), HttpStatus.OK);
	}
	
	
	@GetMapping("/loc/{source}/{destination}")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getBySourceAndDestination(@PathVariable String source, @PathVariable String destination){
		
		return new ResponseEntity<>(shipmentService.getBySourceAndDestination(source, destination), HttpStatus.OK);
	}
	
	
	@GetMapping("/date/{date}")
	public ResponseEntity<ResponseStructure<List<Shipment>>> getByDeliveryDate(@PathVariable Date date){
		
		return new ResponseEntity<>(shipmentService.getByDeliveryDate(date), HttpStatus.OK);
	}
	
	
	@GetMapping("/page/{pn}/{ps}/{field}")
	public ResponseEntity<ResponseStructure<Page<Shipment>>> getByPaginationAndSorting(@PathVariable Integer pn, @PathVariable Integer ps, @PathVariable String field){
		
		return new ResponseEntity<>(shipmentService.getByPaginationAndSorting(pn, ps, field), HttpStatus.OK);
	}
	
	
} 























