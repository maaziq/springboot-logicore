package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Shipment;
import jsp.springboot.enums.ShipmentStatus;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.ShipmentRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	public ResponseStructure<Shipment> createShipment(Shipment shipment){
		
		ResponseStructure<Shipment> res = new ResponseStructure<>();
		
		if (shipment.getPayment() != null) {
	        shipment.getPayment().setShipment(shipment);
	    }

	    if (shipment.getPackageEntity() != null) {
	        shipment.getPackageEntity().setShipment(shipment);
	    }
		
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setMessage("saving shipment in the db");
		res.setData(shipmentRepository.save(shipment));
		
		return res;
	}
	
	
	public ResponseStructure<Shipment> getById(Integer id){
		
		ResponseStructure<Shipment> res = new ResponseStructure<>();
		Optional<Shipment> opt = shipmentRepository.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Fetched by id");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new IdNotFoundException("Id is not avialable");
	}
	
	
	public ResponseStructure<List<Shipment>> getAllShipment(){
		
		ResponseStructure<List<Shipment>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all shipment");
		res.setData(shipmentRepository.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<Shipment> getByTrackingNum(Long num){
		
		ResponseStructure<Shipment> res = new ResponseStructure<>();
		Optional<Shipment> opt = shipmentRepository.findByTrackingNumber(num);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Fetched by tracking Number");
			res.setData(opt.get());
			
			return res;
		}
		else
			throw new NoRecordFoundException("No record found with this tracking num!!");
	}
	
	
	public ResponseStructure<Shipment> updateStatus(Integer id, ShipmentStatus status){
		
		ResponseStructure<Shipment> res = new ResponseStructure<>();
		Optional<Shipment> opt = shipmentRepository.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("updating status!!");
			opt.get().setShipmentStatus(status);
			
			res.setData(shipmentRepository.save(opt.get()));
			
			return res;
		}
		else
			throw new IdNotFoundException("No shipment found");
	}
	
	
	
	
}
