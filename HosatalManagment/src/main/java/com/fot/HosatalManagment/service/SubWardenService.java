package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.SubWarden;
import com.fot.HosatalManagment.repository.SubWardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubWardenService {
    private final SubWardenRepository subWardenRepository;

    @Autowired
    public SubWardenService(SubWardenRepository subWardenRepository) {
        this.subWardenRepository = subWardenRepository;
    }

    public SubWarden getSubWardenById(String subWardenId) {
        return subWardenRepository.findBySubWardenId(subWardenId);
    }
}
