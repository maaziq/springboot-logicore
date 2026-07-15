package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Customer;
import jsp.springboot.entity.DeliveryAgent;
import jsp.springboot.entity.Shipment;
import jsp.springboot.entity.Warehouse;
import jsp.springboot.enums.ShipmentStatus;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.CustomerRepository;
import jsp.springboot.repo.DeliveryAgentRepository;
import jsp.springboot.repo.ShipmentRepository;
import jsp.springboot.repo.WarehouseRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private DeliveryAgentRepository deliveryAgentRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
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
	
	
	public ResponseStructure<Shipment> assignedDeliveryAgent(Integer shipmentId, Integer agentId){
		
		Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new IdNotFoundException("Shipment Id not found"));

        DeliveryAgent deliveryAgent = deliveryAgentRepository.findById(agentId)
                .orElseThrow(() -> new IdNotFoundException("Delivery Agent Id not found"));

        shipment.setDeliveryAgent(deliveryAgent);
        Shipment updatedShipment = shipmentRepository.save(shipment);

        ResponseStructure<Shipment> response = new ResponseStructure<>();

	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Delivery Agent Assigned Successfully");
	        response.setData(updatedShipment);
	
	        return response;	
	}
	
	
	public ResponseStructure<Shipment> assignedWarehouse(Integer shipmentId, Integer warehouseId){
		
		Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new IdNotFoundException("Shipment Id not found"));
		
		Warehouse warehouse = warehouseRepository.findById(warehouseId)
				.orElseThrow(() -> new IdNotFoundException("WarehouseId not found"));
		
		shipment.setWarehouse(warehouse);
		Shipment updatedShipment = shipmentRepository.save(shipment);
		
		 ResponseStructure<Shipment> response = new ResponseStructure<>();

	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Delivery Agent Assigned Successfully");
	        response.setData(updatedShipment);

	        return response;
	}
	
	
	public ResponseStructure<String> deleteShipment(Integer id){
		
		ResponseStructure<String> res = new ResponseStructure<>();
		
		Optional<Shipment> opt = shipmentRepository.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Deleting shipment");
			shipmentRepository.delete(opt.get());
			res.setData("Deleted!!");
			
			return res;
		}
		else
			throw new IdNotFoundException("Id not found");
	}
	
	
	public ResponseStructure<List<Shipment>> getShipmentOfCustomer(Integer customerId){
		
		ResponseStructure<List<Shipment>> res = new ResponseStructure<>();
		
		Optional<Customer> opt = customerRepository.findById(customerId);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching shipments of customer");
			res.setData(shipmentRepository.findByCustomer(opt.get()));
			
			return res;
		}
		else
			throw new NoRecordFoundException("No customer found with this Id!!");
	}
	
	
	

	public ResponseStructure<List<Shipment>> getShipmentOfWarehouse(Integer warehouseId){
		
		ResponseStructure<List<Shipment>> res = new ResponseStructure<>();
		
		Optional<Warehouse> opt = warehouseRepository.findById(warehouseId);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching shipments of warehouse");
			res.setData(shipmentRepository.findByWarehouse(opt.get()));
			
			return res;
		}
		else
			throw new NoRecordFoundException("No Warehouse found with this Id!!");
	}
	
	
	public ResponseStructure<List<Shipment>> getShipmentAssignedDeliveryAgent(Integer agentId){
		
		ResponseStructure<List<Shipment>> res = new ResponseStructure<>();
		
		Optional<DeliveryAgent> opt = deliveryAgentRepository.findById(agentId);
		
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching shipments assigined to Delivery Agent!");
			res.setData(shipmentRepository.findByDeliveryAgent(opt.get()));
			
			return res;
		}
		else
			throw new NoRecordFoundException("No DeliveryAgent found with this Id!!");
	}
	
	
	public ResponseStructure<List<Shipment>> getBySourceAndDestination(String source, String destination){
		
		ResponseStructure<List<Shipment>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching shipment by source and destination");
		res.setData(shipmentRepository.findBySourceAndDestination(source, destination));
		
		return res;
	}
	
	
	
}











