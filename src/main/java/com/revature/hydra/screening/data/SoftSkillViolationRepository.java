package com.revature.hydra.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.SoftSkillViolation;

public interface SoftSkillViolationRepository extends JpaRepository<SoftSkillViolation, Integer>{

}
