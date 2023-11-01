package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Notice;
import com.fot.HosatalManagment.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}

