package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Procedure(procedureName = "GetNoticesByLevel")
    List<Notice> callGetNoticesByLevel(Integer level);
}

