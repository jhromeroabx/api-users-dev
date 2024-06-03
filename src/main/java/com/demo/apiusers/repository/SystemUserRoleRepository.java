package com.demo.apiusers.repository;

import com.demo.apiusers.model.SystemUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRoleRepository extends JpaRepository<SystemUserRole, Integer> {
}
