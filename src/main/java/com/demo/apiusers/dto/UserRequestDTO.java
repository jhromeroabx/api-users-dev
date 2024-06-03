package com.demo.apiusers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDTO implements Serializable {

   @NotBlank
   private String username;
   @NotBlank
   private String password;

}
