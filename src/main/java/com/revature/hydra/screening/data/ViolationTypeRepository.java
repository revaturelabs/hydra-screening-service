package com.revature.hydra.screening.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.ViolationType;

@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer>{

	@Query("select v from ViolationType v")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<ViolationType> findAllViolationTypes();
	
	@Query("select v.violationTypeText from ViolationType v where v.violationTypeId =?1")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	String findViolationTypeByViolationId(Integer violationId);
	
	public ViolationType findByViolationTypeId(Integer violationId);
}
