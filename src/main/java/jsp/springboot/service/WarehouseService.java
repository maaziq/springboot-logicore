package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Warehouse;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.repo.WarehouseRepository;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;
	
	public ResponseStructure<Warehouse> createWarehouse(Warehouse warehouse){
		
		ResponseStructure<Warehouse> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setMessage("Warehouse created sucessfully!");
		res.setData(warehouseRepository.save(warehouse));
		
		return res;
	}
	

	public ResponseStructure<List<Warehouse>> getAllWarehouse(){
		
		ResponseStructure<List<Warehouse>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Fetching warehouse from db");
		res.setData(warehouseRepository.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<Warehouse> getWarehouse(Integer id){
		
		ResponseStructure<Warehouse> res = new ResponseStructure<>();
		Optional<Warehouse> opt = warehouseRepository.findById(id);
		
		if(opt.isPresent()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Fetching warehouse from db");
		res.setData(opt.get());
		
		return res;
		}
		else
			throw new IdNotFoundException("this id not exist in db!!");
		
	}
}
