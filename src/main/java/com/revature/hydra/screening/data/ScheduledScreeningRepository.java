package com.revature.hydra.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.ScheduledStatus;
import com.revature.beans.SimpleScheduledScreening;

public interface ScheduledScreeningRepository extends JpaRepository<SimpleScheduledScreening, Integer> {

	List<SimpleScheduledScreening> findByStatus(String string);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScheduledScreening s set s.status = ?1 where s.scheduledScreeningId = ?2")
	void updateStatus(String screened, Integer scheduledScreeningId);

}
