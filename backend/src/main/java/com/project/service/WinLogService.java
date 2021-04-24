package com.project.service;

import com.project.model.WinLog;
import com.project.repository.WinLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinLogService {
    @Autowired
    WinLogRepository winLogRepository;

    public void saveOrUpdate(WinLog winLog)
    {
        winLogRepository.save(winLog);
    }
}
