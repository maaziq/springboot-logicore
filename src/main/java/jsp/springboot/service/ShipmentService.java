package jsp.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Shipment;
import jsp.springboot.repo.ShipmentRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	public ResponseStructure<Shipment> createShipment(Shipment shipment){
		
		ResponseStructure<Shipment> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setMessage("saving shipment in the db");
		res.setData(shipmentRepository.save(shipment));
		
		return res;
	}
	
	
	
}
