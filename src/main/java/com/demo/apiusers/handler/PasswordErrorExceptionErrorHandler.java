package com.demo.apiusers.handler;
import com.demo.apiusers.dtos.response.ErrorDTO;
import com.demo.apiusers.exception.PasswordErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class PasswordErrorExceptionErrorHandler {
   @ExceptionHandler(PasswordErrorException.class)
   public ResponseEntity <ErrorDTO> PasswordErrorExceptionErrorHandler(PasswordErrorException e) {
      log.error("password no match in database", e);
      ErrorDTO error = ErrorDTO
              .builder()
              .message(e.getMessage())
              .code("PASSWORD_ERROR")
              .status(HttpStatus.BAD_REQUEST.value())
              .build();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
   }
}