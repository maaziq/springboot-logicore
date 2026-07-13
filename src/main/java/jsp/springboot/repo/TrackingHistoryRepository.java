package jsp.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.TrackingHistory;
import jsp.springboot.enums.TrackingStatus;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Integer>{

	List<TrackingHistory> findByStatus(TrackingStatus Status);
	
	List<TrackingHistory> findByShipmentTrackingNumber(Long trackingNumber);
	
	List<TrackingHistory> findByShipmentId(Integer shipmentId);
}
