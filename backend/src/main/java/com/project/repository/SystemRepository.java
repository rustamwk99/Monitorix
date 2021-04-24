package com.project.repository;

import com.project.model.MSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemRepository extends JpaRepository<MSystem,Long> {

}
