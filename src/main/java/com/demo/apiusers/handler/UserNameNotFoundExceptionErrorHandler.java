package com.demo.apiusers.handler;

import com.demo.apiusers.dtos.response.ErrorDTO;
import com.demo.apiusers.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class UserNameNotFoundExceptionErrorHandler {

   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity <ErrorDTO> UserNameNotFoundExceptionErrorHandler(UserNotFoundException e) {
      log.error("userName not found", e);
      ErrorDTO error = ErrorDTO.builder()
                               .message(e.getMessage())
                               .code("USER_NOT_FOUND")
                               .status(HttpStatus.NOT_FOUND.value())
                               .build();
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
   }

}
