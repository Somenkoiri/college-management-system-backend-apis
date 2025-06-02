package com.college.ms.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.ms.payloads.ResponseHandler;
import com.college.ms.payloads.apiResponse;
import com.college.ms.payloads.principalDto;
import com.college.ms.services.principalService;

import jakarta.validation.Valid;

@RestController
public class principalController {

	@Autowired
	private principalService principalService;

	// POST
	@PostMapping("/principal")
	public ResponseEntity<Object> createPrincipal(@Valid @RequestBody principalDto principalDto) {

		return ResponseHandler.responseBuilder("create principal data ! ", HttpStatus.OK.value(),
				this.principalService.createPrincipalDto(principalDto));
	}

	// PUT

	@PutMapping("/principal/{principalId}")
	public ResponseEntity<Object> updatePrincipal(@Valid @RequestBody principalDto principalDto,
			@PathVariable Long principalId) {

		return ResponseHandler.responseBuilder("update principal data !", HttpStatus.OK.value(),
				this.principalService.updatePrincipalDto(principalDto, principalId));
	}

	// DETELE

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/principal/{principalId}")
	public ResponseEntity<apiResponse> deletePrincipal(@Valid @PathVariable Long principalId) {

		this.principalService.deletePrincipal(principalId);

		return new ResponseEntity(new apiResponse("principal data delete !!", HttpStatus.OK.value()), HttpStatus.OK);
	}

	// GET
	@GetMapping("/principal/{principalId}")
	public ResponseEntity<Object> getPrincipal(@Valid @PathVariable Long principalId) {

		return ResponseHandler.responseBuilder("Request principal details are given hear", HttpStatus.OK.value(),
				this.principalService.getPrincipalDto(principalId));
	}
 
	// GET ALL
	@GetMapping("/principal")
	public ResponseEntity<List<principalDto>> getAllPrincipal() {

		return ResponseEntity.ok(this.principalService.getAllPrincipalDtos());
	}

}
