package com.project.main.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.main.Exception.EmptyException;

@ControllerAdvice
public class MainControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<String> handleEmptyException(EmptyException exception) {
		return new ResponseEntity<>("From Advice class; Id dont have any records to search..", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
		return new ResponseEntity<>("Advice class; There is no Id to search in records..", HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String FieldName = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			errors.put(FieldName, msg);
		});
		return new ResponseEntity<Object>(errors, headers, status);
	}
}
