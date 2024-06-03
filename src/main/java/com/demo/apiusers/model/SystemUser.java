package com.demo.apiusers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "system_users")
public class SystemUser {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_system_user")
   private Long idSystemUser;
   @Column(name = "username")
   private String username;
   @Column(name = "user_password")
   private String userPassword;

   @ManyToOne
   @JoinColumn(name = "id_system_user_role")
   private SystemUserRole systemUserRole;

}
