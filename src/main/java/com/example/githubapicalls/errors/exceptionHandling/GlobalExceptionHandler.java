package com.example.githubapicalls.errors.exceptionHandling;

import com.example.githubapicalls.errors.GithubUserNotFoundException;
import com.example.githubapicalls.errors.WrongHeaderException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongHeaderException.class)
    public ResponseEntity<?> handleWrongHeaderException() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_ACCEPTABLE.value(), "Accept header not acceptable"), headers, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(GithubUserNotFoundException.class)
    public ResponseEntity<?> handleGithubUserNotFoundException() {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND.value(), "Github user not found"), HttpStatus.NOT_FOUND);
    }
}
