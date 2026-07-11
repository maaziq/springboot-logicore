package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
