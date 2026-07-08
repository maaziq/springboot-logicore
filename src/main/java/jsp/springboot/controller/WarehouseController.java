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
import jsp.springboot.entity.Warehouse;
import jsp.springboot.service.WarehouseService;

@RequestMapping("/warehouse")
@RestController
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Warehouse>> createWarehouse(@RequestBody Warehouse warehouse){
		
		return new ResponseEntity<>(warehouseService.createWarehouse(warehouse), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Warehouse>>> getAllWarehouse(){
		
		return new ResponseEntity<>(warehouseService.getAllWarehouse(), HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Warehouse>> getByid(@PathVariable Integer id){
		
		return new ResponseEntity<>(warehouseService.getWarehouse(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/location/{location}")
	public ResponseEntity<ResponseStructure<Warehouse>> getByloc(@PathVariable String location){
		
		return new ResponseEntity<>(warehouseService.getByLocation(location), HttpStatus.OK);
	}
	
	
	@GetMapping("/capacity/{capacity}")
	public ResponseEntity<ResponseStructure<List<Warehouse>>> getByCap(@PathVariable Long capacity){
		
		return new ResponseEntity<>(warehouseService.getByCapacity(capacity), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Warehouse>> updateWarehouse(@RequestBody Warehouse warehouse){
		
		return new ResponseEntity<>(warehouseService.updateWarehouse(warehouse), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteWarehouse(@PathVariable Integer id){
		
		return new ResponseEntity<>(warehouseService.deleteWarehouse(id), HttpStatus.OK);
	}
	
}
