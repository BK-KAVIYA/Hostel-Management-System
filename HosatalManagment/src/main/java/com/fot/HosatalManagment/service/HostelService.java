package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Hostel;
import com.fot.HosatalManagment.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelService {
    private final HostelRepository hostelRepository;

    @Autowired
    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    public Hostel getHostelInformation(String hostelName) {
        return hostelRepository.getHostelInformation(hostelName);
    }
}
