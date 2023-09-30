package com.as.drs.repository;

import com.as.drs.entity.DRS_Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DRS_ScoreRepository extends JpaRepository<DRS_Score, Long> {


}
