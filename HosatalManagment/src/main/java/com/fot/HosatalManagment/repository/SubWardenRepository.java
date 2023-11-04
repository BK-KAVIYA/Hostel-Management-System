package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.SubWarden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubWardenRepository extends JpaRepository<SubWarden, String> {
    SubWarden findBySubWardenId(String subWardenId);
}

