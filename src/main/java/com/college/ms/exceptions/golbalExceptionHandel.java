package com.college.ms.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college.ms.payloads.apiResponse;

@RestControllerAdvice
public class golbalExceptionHandel {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<apiResponse> dataNotFound(ResourceNotFound ex) {
		String message = ex.getMessage();
		apiResponse apiResponse = new apiResponse(message, HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<apiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handelMethodAurgumentNotValid(MethodArgumentNotValidException ex) {

		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);

		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);

	}
}