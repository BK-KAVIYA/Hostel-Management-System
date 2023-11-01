package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepo extends CrudRepository<Complaint,Integer> {
    @Procedure(name = "GetComplaintsByStudent")
    List<Complaint> GetComplaintsByStudent(String ID);

//    @Procedure(name = "GetComplaintDetails")
//    Optional<Complaint> GetComplaintDetails(int fileName);

    @Query(value = "CALL GetComplaintDetails(:complaintId)", nativeQuery = true)
    Optional<Complaint> getComplaintDetails(@Param("complaintId") int complaintId);
}
