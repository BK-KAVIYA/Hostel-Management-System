package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HostelRepository extends JpaRepository<Hostel, Long> {
    @Query(value = "CALL GetHostelInformation(:hostelName)", nativeQuery = true)
    Hostel getHostelInformation(@Param("hostelName") String hostelName);


}
