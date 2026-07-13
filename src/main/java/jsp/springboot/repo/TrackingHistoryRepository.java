package jsp.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.TrackingHistory;
import jsp.springboot.enums.TrackingStatus;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Integer>{

	List<TrackingHistory> findByTrackingStatus(TrackingStatus status);
}
