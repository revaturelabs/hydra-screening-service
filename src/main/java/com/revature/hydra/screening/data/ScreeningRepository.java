package com.revature.hydra.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer> {
	
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.aboutMeCommentary = ?1 where s.screeningId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void changeAboutMeCommentaryByScreeningId(String introComment, Integer screeningId);
	
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.generalCommentary = ?1 where s.screeningId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void changeGeneralCommentaryByScreeningId(String generalComment, Integer screeningId);
	
}
