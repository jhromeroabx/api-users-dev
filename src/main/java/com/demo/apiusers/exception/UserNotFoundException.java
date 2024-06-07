package com.demo.apiusers.exception;

public class UserNotFoundException extends RuntimeException {

   public UserNotFoundException(String message) {
      super(message);
   }

}
