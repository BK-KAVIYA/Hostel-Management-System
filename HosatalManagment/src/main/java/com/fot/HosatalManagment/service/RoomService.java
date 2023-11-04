package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.RoomAndCount;
import com.fot.HosatalManagment.repository.RoomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public List<RoomAndCount> GetAllRoomNumbers() {

      //  return roomRepository.GetAllRoomNumbers();



        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GetAllRoomNumbers");
        query.execute();

        List<Object[]> results = query.getResultList();

        List<RoomAndCount> roomResults = new ArrayList<>();
        for (Object[] result : results) {
            int roomNumber = (int) result[0];
            int studentCount = (int) result[1];
            roomResults.add(new RoomAndCount(roomNumber, studentCount));
        }

        return roomResults;
    }
}
