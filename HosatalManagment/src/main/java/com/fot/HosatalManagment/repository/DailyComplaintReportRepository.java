package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.DailyComplaintReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DailyComplaintReportRepository extends JpaRepository<DailyComplaintReport, Long> {
    @Query(value = "SELECT * FROM DailyComplaintReport", nativeQuery = true)
    List<DailyComplaintReport> findAllDailyComplaintReports();
}

