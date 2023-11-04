package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Notice;
import com.fot.HosatalManagment.entity.Room;
import com.fot.HosatalManagment.entity.RoomAndCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Procedure(procedureName = "GetAllRoomNumbers")
    List<Object[]> GetAllRoomNumbers();
}

