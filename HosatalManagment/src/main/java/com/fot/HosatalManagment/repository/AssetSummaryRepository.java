package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.AssetSummary;
import com.fot.HosatalManagment.entity.DailyComplaintReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetSummaryRepository extends JpaRepository<AssetSummary, Long> {
    @Query(value = "SELECT * FROM AssetSummary", nativeQuery = true)
    List<AssetSummary> findAssetSummariesReports();
}
