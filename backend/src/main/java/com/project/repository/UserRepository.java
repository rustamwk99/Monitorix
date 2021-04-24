package com.project.repository;

import com.project.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MUser,Long> {
    MUser findUserByLogin(String login);
    List<MUser> findAll();

}
