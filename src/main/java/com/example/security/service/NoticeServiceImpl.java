package com.example.security.service;

import com.example.security.entity.Notice;
import com.example.security.persistence.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> getList() {
        return noticeRepository.findAll();
    }
}
