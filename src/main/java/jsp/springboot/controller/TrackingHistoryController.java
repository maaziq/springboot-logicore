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
import jsp.springboot.entity.TrackingHistory;
import jsp.springboot.enums.TrackingStatus;
import jsp.springboot.service.TrackingHistoryService;

@RequestMapping("/tracking")
@RestController
public class TrackingHistoryController {

	@Autowired
	private TrackingHistoryService trackingHistoryService;
	
	
	@GetMapping("id/{id}")
	public ResponseEntity<ResponseStructure<TrackingHistory>> getById(@PathVariable Integer id){
		
		return new ResponseEntity<>(trackingHistoryService.getByIdTracking(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<TrackingHistory>>> getAlltracking(){
		
		return new ResponseEntity<>(trackingHistoryService.getAllTracking(), HttpStatus.OK);
	}
	
	
	@GetMapping("/trackingnum/{shipmentNum}")
	public ResponseEntity<ResponseStructure<List<TrackingHistory>>> getByTrackingNumber(@PathVariable Long shipmentNum){
		
		return new ResponseEntity<>(trackingHistoryService.getTrackingHistoryByTrackingNumber(shipmentNum), HttpStatus.OK);
	}
	
	
	@GetMapping("/status/{status}")
	public ResponseEntity<ResponseStructure<List<TrackingHistory>>> getByStatus(@PathVariable TrackingStatus status){
		
		return new ResponseEntity<>(trackingHistoryService.getByStatus(status), HttpStatus.OK);
	}
	
	
	@GetMapping("/shipment/{id}")
	public ResponseEntity<ResponseStructure<List<TrackingHistory>>> getByShipment(Integer id){
		
		return new ResponseEntity<>(trackingHistoryService.getByShipment(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<TrackingHistory>> updateTrackingHistoy(@PathVariable TrackingHistory history){
		
		return new ResponseEntity<>(trackingHistoryService.updateTracking(history), HttpStatus.OK);
		
	}
}
