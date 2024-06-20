package com.demo.apiusers.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO implements Serializable {

   @NotBlank
   @Pattern(regexp = "^[A-Za-z]+@(gmail.com|outlook.com|yahoo.com)$",
           message = "{The email must contain letters at the beginning, @ and a valid domain (gmail.com, outlook.com or yahoo.com)}")
   private String email;

   @NotBlank(message = "Password is mandatory")
   @Size(min = 8, max = 20, message = "Password length should be between 8 and 20 characters")
   @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message =
           "Password should contain at least one uppercase, one lowercase, one digit, and one special character")
   private String password;

}
