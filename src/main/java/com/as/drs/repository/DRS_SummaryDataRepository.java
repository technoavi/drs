package com.as.drs.repository;

import com.as.drs.entity.DRS_SummaryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DRS_SummaryDataRepository extends JpaRepository<DRS_SummaryData, Long> {

    @Query(value = "SELECT SUM(ds.ncs_marginamount) FROM drs_summarydata ds " +
            "WHERE ds.dealerId = :dealerId AND ds.fiscalmonth BETWEEN :startDate AND :endDate", nativeQuery = true)
    Double calculateTotalNCSMarginAmount(
            @Param("dealerId") Long dealerId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}
