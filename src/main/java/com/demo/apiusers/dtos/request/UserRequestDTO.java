package com.demo.apiusers.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

   @NotBlank
   @Email(message = "Email should be valid")
   private String email;
   @NotBlank
   @Size(min = 8, max = 20)
   @NotBlank(message = "Password is mandatory")
   @Size(min = 8, max = 20, message = "Password length should be between 8 and 20 characters")
   @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message =
           "Password should contain at least one uppercase, one lowercase, one digit, and one special character")
   private String password;

}
