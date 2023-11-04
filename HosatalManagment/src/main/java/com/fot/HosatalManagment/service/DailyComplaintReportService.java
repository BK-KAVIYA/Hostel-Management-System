package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.DailyComplaintReport;
import com.fot.HosatalManagment.repository.DailyComplaintReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyComplaintReportService {
    @Autowired
    private DailyComplaintReportRepository repository;

    public List<DailyComplaintReport> getComplaintsForToday() {
        return repository.findAllDailyComplaintReports();
    }
}

