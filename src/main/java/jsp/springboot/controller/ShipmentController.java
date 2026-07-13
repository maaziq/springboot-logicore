package jsp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Shipment;
import jsp.springboot.service.ShipmentService;

@RequestMapping("/shipment")
@RestController
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Shipment>> createShipment(@PathVariable Shipment shipment){
		
		return new ResponseEntity<>(shipmentService.createShipment(shipment), HttpStatus.ACCEPTED);
	}
}
