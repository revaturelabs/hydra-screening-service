package com.revature.hydra.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SoftSkillViolation;

public interface SoftSkillViolationRepository extends JpaRepository<SoftSkillViolation, Integer>{

	@Modifying(clearAutomatically = true)
	@Query("delete SoftSkillViolation where violation = ?1")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void deleteViolationByViolationType(String violationType);
	
	@Query("select sv from SoftSkillViolation sv where sv.screeningId =?1")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<SoftSkillViolation> findSoftSkillViolationsByScreeningId(SimpleScreening ss);
}
