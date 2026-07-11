package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.PackageEntity;
import jsp.springboot.service.PackageEntityService;

@RequestMapping("/package")
@RestController
public class PackageEntityController {

	@Autowired
	private PackageEntityService packageService;
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<PackageEntity>>> getAlPackageEntity(){
		
		return new ResponseEntity<>(packageService.getAllPackage(), HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<PackageEntity>> getById(@PathVariable Integer id){
		
		return new ResponseEntity<>(packageService.getById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/shipment/{id}")
	public ResponseEntity<ResponseStructure<PackageEntity>> getByShipment(@PathVariable Integer id){
		
		return new ResponseEntity<>(packageService.getByShipment(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<PackageEntity>> updatePackEntity(@RequestBody PackageEntity packageEntity){
		
		return new ResponseEntity<>(packageService.updatePackage(packageEntity), HttpStatus.OK );
	}
	
}
