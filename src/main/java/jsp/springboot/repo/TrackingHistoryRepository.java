package jsp.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.TrackingHistory;

public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Integer>{

}
