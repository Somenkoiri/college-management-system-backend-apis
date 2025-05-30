package com.college.ms.payloads;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> responseBuilder(String message, int statusCode, Object responseObj) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("status", statusCode); // <-- Number instead
		response.put("data", responseObj);
		return ResponseEntity.status(statusCode).body(response);
	}
}
