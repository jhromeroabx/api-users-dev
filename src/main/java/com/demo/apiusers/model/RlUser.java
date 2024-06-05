package com.demo.apiusers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rl_user")
public class RlUser {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
   @Column(name = "id_rl_user")
   private Long id;
   @Column(nullable = false, unique = true, name = "username")
   private String username;
   @Column(nullable = false, name = "user_password")
   private String password;
   @ManyToOne
   @JoinColumn(name = "id_system_user_role")
   private RlRole role;

}
