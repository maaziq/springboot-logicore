package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.TrackingHistory;
import jsp.springboot.enums.TrackingStatus;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.TrackingHistoryRepository;

@Service
public class TrackingHistoryService {

	@Autowired
	private TrackingHistoryRepository trackingHistoryRepository;
	
	
	
	
	public ResponseStructure<TrackingHistory> getByIdTracking(Integer id){
		
		ResponseStructure<TrackingHistory> res = new ResponseStructure<>();
		
		Optional<TrackingHistory> opt = trackingHistoryRepository.findById(id);
		
		if(opt.isPresent()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all the Tracking History from db");
		res.setData(opt.get());
		
		return res;
		}
		else
			throw new IdNotFoundException("Id is not avialable ");
	}
	
	
	public ResponseStructure<List<TrackingHistory>> getAllTracking(){
		
		ResponseStructure<List<TrackingHistory>> res = new ResponseStructure<>();
		
		
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("fetching all the Tracking History from db");
			res.setData(trackingHistoryRepository.findAll());
			
			return res;
	}

	
	public ResponseStructure<List<TrackingHistory>> getTrackingHistoryByTrackingNumber(Long trackingNumber){
		
		ResponseStructure<List<TrackingHistory>> res = new ResponseStructure<>();

			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("feting data from shipment");
			res.setData(trackingHistoryRepository.findByShipmentTrackingNumber(trackingNumber));
		
			return res;
	}
	
	
	public ResponseStructure<List<TrackingHistory>> getByStatus(TrackingStatus status){
		
		ResponseStructure<List<TrackingHistory>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching TrackingHistory By Status!!");
		res.setData(trackingHistoryRepository.findByStatus(status));
		
		return res;
	}
	
	
	public ResponseStructure<List<TrackingHistory>> getByShipment(Integer id){
		
		ResponseStructure<List<TrackingHistory>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching TrackingHistory By shipment!!");
		res.setData(trackingHistoryRepository.findByShipmentId(id));
		
		return res;
		
	}
	
	
	public ResponseStructure<TrackingHistory> updateTracking(TrackingHistory history){
		
		ResponseStructure<TrackingHistory> res = new ResponseStructure<>();
		
		if(history.getId() == null)
			throw new IdNotFoundException("Id is not available");
		
		Optional<TrackingHistory> opt = trackingHistoryRepository.findById(history.getId());
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("updating tracking history!");
			res.setData(trackingHistoryRepository.save(history));
			
			return res;
		}
		else
			throw new NoRecordFoundException("No record found!!");	
	}
	
	
	
	
}
