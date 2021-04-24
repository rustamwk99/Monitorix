package com.project.controller;

import com.project.model.LinuxLog;
import com.project.model.MUser;
import com.project.model.Trigger;
import com.project.model.WinLog;
import com.project.repository.LinuxLogRepository;
import com.project.repository.TriggerRepository;
import com.project.repository.UserRepository;
import com.project.repository.WinLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/scr")
public class ScriptController {
    private UserRepository userRepository;
    @Autowired
    private TriggerRepository triggerRepository;
    @Autowired
    private WinLogRepository winLogRepository;

    @Autowired
    private LinuxLogRepository linuxLogRepository;

    @GetMapping("/info")
    public String findInfo(@RequestParam(name = "index") long index,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "source") String source,
                           @RequestParam(name = "instance_id") long instance_id,
                           @RequestParam(name = "message") String message,
                           Model model, WinLog winLog, MUser mUser) {
        model.addAttribute("logs", winLogRepository.findAll());
        model.getAttribute("login");
        winLog.setLogin(UserController.data);
        winLogRepository.save(winLog);

        model.addAttribute("index",index);

        return "info";
    }

    @GetMapping("/linux")
    public String findLinuxInfo(@RequestParam(name = "hostname") String hostname,
                                @RequestParam(name = "priority") int priority,
                                @RequestParam(name = "source") String source,
                                @RequestParam(name = "message") String message,
                                Model model, LinuxLog linuxLog, MUser mUser
                                ){
        linuxLog.setLogin(UserController.data);
        linuxLogRepository.save(linuxLog);
        return "linux";
    }

    @RequestMapping("/test")
    public String findInfo2(Model model, @ModelAttribute("login") String log) {
        model.addAttribute("login",log);
        System.out.println(UserController.data+"ssss");

        return "test";
    }
    @RequestMapping(value = "/trigger",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List findTrigger(Model model, Trigger trigger) {
        model.addAttribute("trigger",triggerRepository.findAllByLogin(UserController.data));
        return triggerRepository.findAllByLoginAndOs(UserController.data,"Windows");
    }

    @RequestMapping(value = "/triggerLin",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List findTriggerLin(Model model, Trigger trigger) {
        model.addAttribute("trigger",triggerRepository.findAllByLogin(UserController.data));
        return triggerRepository.findAllByLoginAndOs(UserController.data,"Linux");
    }



}
