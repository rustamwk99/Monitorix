package com.project.repository;

import com.project.model.LinuxLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinuxLogRepository extends CrudRepository<LinuxLog,Long> {
    List<LinuxLog> findAllByLogin(String login);
    List<LinuxLog> findAllByPriority(int priority);
}
