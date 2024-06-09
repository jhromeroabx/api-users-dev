package com.demo.apiusers.repository;

import com.demo.apiusers.model.RlUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RlUserRepository extends JpaRepository <RlUser, Long> {

   @Query("SELECT r FROM RlUser r WHERE r.username = :email")
   RlUser findByUserName(@Param("email") String email);

}
