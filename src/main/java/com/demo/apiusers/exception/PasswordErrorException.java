package com.demo.apiusers.exception;
public class PasswordErrorException extends RuntimeException {
   public PasswordErrorException(String message) {
      super(message);
   }
}