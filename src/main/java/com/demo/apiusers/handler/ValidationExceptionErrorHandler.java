package com.demo.apiusers.handler;

import com.demo.apiusers.dtos.response.ErrorDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ValidationExceptionErrorHandler {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity <ErrorDTO> validationErrorHandler(MethodArgumentNotValidException e) {
      List <String> errors = e.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

      log.error("Validation error");
      ErrorDTO error = ErrorDTO.builder()
                               .message("Validation error")
                               .code("VALIDATION_ERROR")
                               .status(HttpStatus.BAD_REQUEST.value())
                               .errors(errors)
                               .build();

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
   }

}
