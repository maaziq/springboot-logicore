package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.DeliveryAgent;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.DeliveryAgentRepository;

@Service
public class DeliveryAgentService {

	@Autowired
	private DeliveryAgentRepository deliveryAgentRepo;
	
	
	public ResponseStructure<DeliveryAgent> createAgent(DeliveryAgent deliveryAgent){
		
		ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.ACCEPTED.value());
		res.setMessage("DeliveryAgent is created !");
		res.setData(deliveryAgentRepo.save(deliveryAgent));
		
		return res;
	}
	
	
	public ResponseStructure<List<DeliveryAgent>> getAllAgents(){
		
		ResponseStructure<List<DeliveryAgent>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("All agents fetched sucessfilly!!");
		res.setData(deliveryAgentRepo.findAll());
		
		return res;
	}
	
	
	public ResponseStructure<DeliveryAgent> getById(Integer id){
		
		ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
		Optional<DeliveryAgent> opt = deliveryAgentRepo.findById(id);
		
		if(opt.isPresent()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching agent by id");
		res.setData(opt.get());
		
		return res;
		}
		else
			throw new IdNotFoundException("Id doesnt exist in db!!");
	}
	
	
	public ResponseStructure<DeliveryAgent> getByContact(Long contact){
			
			ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
			Optional<DeliveryAgent> opt = deliveryAgentRepo.findByAgentContact(contact);
			
			if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching agent by Contact");
			res.setData(opt.get());
			
			return res;
			}
			else
				throw new NoRecordFoundException("Contact doesnt exist!!");
	}
	
	
	public ResponseStructure<DeliveryAgent> getByVehicleNum(String number){
		
		ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
		Optional<DeliveryAgent> opt = deliveryAgentRepo.findByVehicleNumber(number);
		
		if(opt.isPresent()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching agent by vehicleNumber");
		res.setData(opt.get());
		
		return res;
		}
		else
			throw new NoRecordFoundException("Vehicle doesnt exist!!");
	}
	
	
	public ResponseStructure<List<DeliveryAgent>> getByRatingGreater(Integer rating){
		
		ResponseStructure<List<DeliveryAgent>> res = new ResponseStructure<>();

		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching agent by vehicleNumber");
		res.setData(deliveryAgentRepo.findByRatingGreaterThan(rating));
		
		return res;
	}
	
	
	public ResponseStructure<DeliveryAgent> updateAgent(DeliveryAgent agent){
		
		ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
		
		if(agent.getId() == null) 
			throw new IdNotFoundException("Id is not avialable");
		
		Optional<DeliveryAgent> opt = deliveryAgentRepo.findById(agent.getId());
		
		if(opt.isPresent()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Delivery agent is updated sucessfully!!");
		res.setData(deliveryAgentRepo.save(agent));
		
		return res;
		
		}
		
		else
			throw new NoRecordFoundException("No agent is persent in the db!");
	}
	
	
	public ResponseStructure<String> deleteAgent(Integer id){
		
		ResponseStructure<String> res = new ResponseStructure<>();
		
		Optional<DeliveryAgent> opt = deliveryAgentRepo.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Agent deleted sucessfully");
			res.setData("Deleted");
			deliveryAgentRepo.delete(opt.get());
			
			return res;
		}
		else
			throw new NoRecordFoundException("no record is avialable");
	}
	
	
	public ResponseStructure<DeliveryAgent> updateAgentAvability(Integer id, Boolean avialability){
		
		ResponseStructure<DeliveryAgent> res = new ResponseStructure<>();
		
		Optional<DeliveryAgent> opt = deliveryAgentRepo.findById(id);
		
		if(opt.isPresent()) {
			
	        DeliveryAgent agent = opt.get();
	        agent.setAvialability(avialability);
	        DeliveryAgent updatedAgent = deliveryAgentRepo.save(agent);
	        
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Avialabilty updated sucessfully");
			res.setData(updatedAgent);
			
			return res;
		}
		else
			throw new NoRecordFoundException("agent is not present!");
	}
	
}
