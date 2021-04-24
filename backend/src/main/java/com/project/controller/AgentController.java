package com.project.controller;

import com.project.model.MSystem;
import com.project.model.Trigger;
import com.project.repository.TriggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AgentController {

    @Autowired
    TriggerRepository triggerRepository;

    public AgentController(TriggerRepository triggerRepository) {
        this.triggerRepository = triggerRepository;
    }

    @RequestMapping("/user_agent")
    public MSystem getUserAgent(@RequestHeader MSystem agent){

        agent.setName(HttpHeaders.USER_AGENT);

        return agent;
    }

    @GetMapping("/user_agent/download/Linux")
    public ResponseEntity downloadFileLinux(){
        Resource resource = new ClassPathResource("scripts/logs.linux.sh");
        String filename = "logs.sh";
//        try {
//            resource = new UrlResource(path.toUri());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        return ResponseEntity.ok()
                .contentType(new MediaType("text", "sh"))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + filename)
                .body(resource);
    }
    @GetMapping("/user_agent/download/Windows")
    public ResponseEntity downloadFileWindows(){


        Resource resource = new ClassPathResource("scripts/winlogs.rar");
        Resource config = new ClassPathResource("scripts/logs.win.xml");
        String filename = "logs.sh";
        String configname = "logs.xml";

        return ResponseEntity.ok()
                .contentType(new MediaType("text", "rar"))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + filename)
                .body(resource);
    }

    @GetMapping("/user_agent/download/MacOs")
    public ResponseEntity downloadFileMacOs(){

        Resource resource = new ClassPathResource("scripts/logs.mac.txt");


        String filename = "logs.sh";

        return ResponseEntity.ok()
                .contentType(new MediaType("text", "sh"))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + filename)
                .body(resource);
    }

    @GetMapping("/user_agent/triggers")
    public Iterable<Trigger> getTriggers() {
        System.out.println("Trigger"+triggerRepository.findAll().toString());
        return triggerRepository.findAllByLogin(UserController.data);
    }

    @GetMapping("/user_agent/triggers/{id}")
    public Trigger getTrigger(@PathVariable("id") Long id) {
        return triggerRepository.findById(id).get();
    }

    @DeleteMapping("/user_agent/triggers/{id}")
    public HttpStatus deleteTrigger(@PathVariable("id") Long id) {

        triggerRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/user_agent/triggers/")
    public HttpStatus addTriggers(@RequestBody Trigger trigger){
        triggerRepository.save(trigger);

        return HttpStatus.CREATED;
    }
}
