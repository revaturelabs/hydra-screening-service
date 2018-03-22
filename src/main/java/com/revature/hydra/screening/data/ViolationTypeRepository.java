package com.revature.hydra.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.ViolationType;

@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Integer>{

	
}
