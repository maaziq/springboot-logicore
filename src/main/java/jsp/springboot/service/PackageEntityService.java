package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.entity.PackageEntity;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.repo.PackageEntityRepository;

@Service
public class PackageEntityService {

	@Autowired
	private PackageEntityRepository packageEntityRepository;
	
	
	public ResponseStructure<List<PackageEntity>> getAllPackage(){
		
		ResponseStructure<List<PackageEntity>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all the data");
		res.setData(packageEntityRepository.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<PackageEntity> getById(Integer id){
		
		ResponseStructure<PackageEntity> res = new ResponseStructure<>();
		Optional<PackageEntity> opt = packageEntityRepository.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetch by id");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new IdNotFoundException("this id is not available in the db!!");
	}
	
	
	public ResponseStructure<PackageEntity> getByShipment(Integer shipmentId){
		
		ResponseStructure<PackageEntity> res = new ResponseStructure<>();
		Optional<PackageEntity> opt = packageEntityRepository.findByShipmentId(shipmentId);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching by shipment!");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new IdNotFoundException("this id is not available in the db!!");

	}
	
	
	public ResponseStructure<PackageEntity> updatePackage(PackageEntity packageEntity){
		
		ResponseStructure<PackageEntity> res = new ResponseStructure<>();
		if(packageEntity.getId() == null)
			throw new IdNotFoundException("Id  id not available");
		
		Optional<PackageEntity> opt = packageEntityRepository.findById(packageEntity.getId());
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Updating the PackageEntity");
			res.setData(packageEntityRepository.save(packageEntity));
			
			return res;
		}
		else
			throw new NoRecordFoundException("No Record found!");
	}
	
	
	
	
}
