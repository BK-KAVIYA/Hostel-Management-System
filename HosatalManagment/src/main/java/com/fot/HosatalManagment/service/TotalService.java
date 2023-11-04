package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.repository.AssetRepository;
import com.fot.HosatalManagment.repository.ComplaintRepo;
import com.fot.HosatalManagment.repository.StudentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TotalService {
    @PersistenceContext
    private EntityManager entityManager;

    public Integer getTotalComplaints() {
        Query query = entityManager.createNativeQuery("SELECT getTotalComplaints()");
        return ((Integer) query.getSingleResult()).intValue();
    }

    public Integer getTotalStudents() {
        Query query = entityManager.createNativeQuery("SELECT GetTotalStudents()");
        return ((Integer) query.getSingleResult()).intValue();
    }

    public Integer getTotalAssets() {
        Query query = entityManager.createNativeQuery("SELECT GetTotalAsset()");
        return ((Integer) query.getSingleResult());
    }
    public Integer getStudentLevel(String studentId) {
        Query query = entityManager.createNativeQuery("SELECT GetStudentLevel(:studentId)");
        query.setParameter("studentId", studentId);
        Object result = query.getSingleResult();
        return result != null ? ((Integer) result).intValue() : null;
    }

//    public Integer GetStudentComplaintCount(String studentId) {
//        Query query = entityManager.createNativeQuery("SELECT GetStudentComplaintCount(:studentId)");
//        query.setParameter("studentId", studentId);
//        Object result = query.getSingleResult();
//        return result != null ? ((Integer) result).intValue() : null;
//    }
}

