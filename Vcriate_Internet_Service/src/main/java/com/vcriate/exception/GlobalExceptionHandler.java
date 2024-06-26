package com.vcriate.exception;

import java.time.LocalDateTime;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(VcriateException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(VcriateException ie, WebRequest req) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(MethodArgumentNotValidException ie, WebRequest req) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(ConstraintViolationException ie, WebRequest req) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myanyExphandler(Exception ie, WebRequest req) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	

}
