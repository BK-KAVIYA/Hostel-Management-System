package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Notice;
import com.fot.HosatalManagment.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Transactional
    public List<Notice> getNoticesByLevel(Integer level) {
        return noticeRepository.callGetNoticesByLevel(level);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public Notice callGetNoticeDetails(int noticeId) {
        String callProcedureSql = "CALL GetNoticeDetails(?)";
        return jdbcTemplate.queryForObject(callProcedureSql, new Object[]{noticeId}, (rs, rowNum) -> {
            Notice notice = new Notice();
            notice.setNid((long)rs.getInt("nid"));
            notice.setNdate_time(rs.getTimestamp("ndate_time").toString());
            notice.setN_person(rs.getString("n_person"));
            notice.setN_topic(rs.getString("n_topic"));
            notice.setNotice(rs.getString("notice"));
            notice.setN_level(rs.getInt("n_level"));
            return notice;
        });
    }
//    public Notice getNoticeById(Integer ID){
//        return noticeRepository.findAllById(ID);
//    }

}

