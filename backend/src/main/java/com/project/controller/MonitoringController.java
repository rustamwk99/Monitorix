package com.project.controller;

import com.project.model.LinuxLog;
import com.project.model.WinLog;
import com.project.repository.LinuxLogRepository;
import com.project.repository.WinLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MonitoringController {
    @Autowired
    WinLogRepository winLogRepository;
    @Autowired
    LinuxLogRepository linuxLogRepository;

    @GetMapping("/monitoring")
    public List<WinLog> monitoring(HttpSession session){

        return (List<WinLog>) winLogRepository.findAllByLogin(UserController.data);
    }

    @GetMapping("/monitoringLin")
    public List<LinuxLog> monitoringLin(HttpSession session){

        return (List<LinuxLog>) linuxLogRepository.findAllByLogin(UserController.data);
    }

}
