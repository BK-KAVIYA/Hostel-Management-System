package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.AssetSummary;
import com.fot.HosatalManagment.entity.DailyComplaintReport;
import com.fot.HosatalManagment.repository.AssetSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssetSummaryService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void updateAssetSummaryView() {
        jdbcTemplate.execute("CALL UpdateAssetSummaryView()");
    }

    @Autowired
    private AssetSummaryRepository assetSummaryRepository;

    public List<AssetSummary> getAllAssetSummaries() {
        return assetSummaryRepository.findAll();
    }

    public List<AssetSummary> getAssetReport() {
        return assetSummaryRepository.findAssetSummariesReports();
    }
}

