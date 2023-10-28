package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.entity.Student;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ComplaintRepo extends CrudRepository<Complaint,Integer> {
    @Procedure(name = "GetComplaintsByStudent")
    Iterable<Complaint> GetComplaintsByStudent(String ID);
}
