package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}
