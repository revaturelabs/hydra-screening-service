package com.revature.hydra.screening.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.SimpleScreening;

@Repository
public interface ScreeningRepository extends JpaRepository<SimpleScreening, Integer> {

}
