package com.demo.apiusers.exception;
public class RepeatUserException extends RuntimeException {
   public RepeatUserException(String message) {
      super(message);
   }
}