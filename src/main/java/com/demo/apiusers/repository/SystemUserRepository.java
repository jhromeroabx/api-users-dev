package com.demo.apiusers.repository;

import com.demo.apiusers.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

   @Query("select u from SystemUser u where lower(u.username) = lower(:username)")
   SystemUser findByUsername(@Param("username") String username);

}
