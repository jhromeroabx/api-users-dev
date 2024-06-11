package com.demo.apiusers.handler;

import com.demo.apiusers.dtos.response.ErrorDTO;
import com.demo.apiusers.exception.RepeatUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RepeatUserErrorHandler {


   @ExceptionHandler(RepeatUserException.class)
   public ResponseEntity <ErrorDTO> RepeatUserExceptionHandler(RepeatUserException e) {
      log.error("Repeat User", e);
      ErrorDTO errorDTO = ErrorDTO
              .builder().message("Repeat User")
              .code("REPEAT_USER").status(HttpStatus.BAD_REQUEST.value()).build();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);


   }

}
