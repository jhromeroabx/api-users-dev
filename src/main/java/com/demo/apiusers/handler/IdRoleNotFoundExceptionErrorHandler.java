package com.demo.apiusers.handler;
import com.demo.apiusers.dtos.response.ErrorDTO;
import com.demo.apiusers.exception.IdRoleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class IdRoleNotFoundExceptionErrorHandler {
   @ExceptionHandler(IdRoleNotFoundException.class)
   public ResponseEntity <ErrorDTO> IdRoleNotFoundHandler(IdRoleNotFoundException e) {
      log.error("Id Role Not Found", e);
      ErrorDTO errorDTO = ErrorDTO
              .builder().message("Id Role Not Found")
              .code("ID_ROLE_NOT_FOUND").status(HttpStatus.NOT_FOUND.value()).build();
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
   }
}