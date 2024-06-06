package com.demo.apiusers.dtos.response;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements Serializable {

   private String message;
   private String code;
   private Integer status;
   private List <String> errors;

}
