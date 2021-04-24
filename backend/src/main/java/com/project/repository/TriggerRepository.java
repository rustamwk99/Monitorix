package com.project.repository;

import com.project.model.MUser;
import com.project.model.Trigger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriggerRepository extends JpaRepository<Trigger,Long> {
    List<Trigger> findAllByTrigger(String trigger);
    List<Trigger> findAllByLogin(String login);
    List<Trigger> findAllByLoginAndOs(String login,String os);

}
