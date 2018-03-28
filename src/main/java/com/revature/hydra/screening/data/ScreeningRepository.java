package com.revature.hydra.screening.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SoftSkillViolation;

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
	
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.aboutMeCommentary = ?1 where s.screeningId = ?2")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void updateaboutMeCommentaryByScreeningId(String aboutMeCommentary, Integer screeningId);
	
	@Modifying(clearAutomatically = true)
	@Query("update SimpleScreening s set s.status = ?1, s.softSkillsVerdict = ?2, s.softSkillCommentary = ?3,"+
			"s.endDateTime = ?4, s.compositeScore = ?5 where s.screeningId = ?6")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void updateQuestionByScreeningId(String status, Boolean softSkillsVerdict, String softSkillCommentary, 
			Date endDateTime, Double compositeScore, Integer screeningId);
}
