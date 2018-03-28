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
	
	List<SoftSkillViolation> findByScreeningId(SimpleScreening ss);
}
