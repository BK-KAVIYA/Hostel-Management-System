package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.AssetSummary;
import com.fot.HosatalManagment.entity.DailyComplaintReport;
import com.fot.HosatalManagment.service.AssetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assetsummary")
public class AssetSummaryController {
    @Autowired
    private AssetSummaryService assetSummaryService;

    @GetMapping("/update")
    public ResponseEntity<String> updateAssetSummary() {
        assetSummaryService.updateAssetSummaryView();
        return ResponseEntity.ok("AssetSummary view updated successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssetSummary>> getAllAssetSummaries() {
        List<AssetSummary> summaries = assetSummaryService.getAllAssetSummaries();
        return ResponseEntity.ok(summaries);
    }

    @GetMapping("/getsummary")
    public ResponseEntity<List<AssetSummary>> getAssetSummary() {
        List<AssetSummary> complaints = assetSummaryService.getAssetReport();
        return ResponseEntity.ok(complaints);
    }
}

