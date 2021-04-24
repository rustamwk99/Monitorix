package com.project.repository;

import com.project.model.WinLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinLogRepository extends CrudRepository<WinLog,Long> {
    List<WinLog> findAllByLogin(String login);
    List<WinLog> findTop5ByLogin(String login);
    List<WinLog> findAllByLoginAndDescriptionOrDescription(String login,String description,String description2);


}
