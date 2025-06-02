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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.ms.payloads.ResponseHandler;
import com.college.ms.payloads.apiResponse;
import com.college.ms.payloads.batchDto;
import com.college.ms.services.batchService;


@RestController
@RequestMapping("/batchname")
public class batchNameController {

	@Autowired
	private batchService batchService;

	@PostMapping("")
	public ResponseEntity<Object> createBatchName(@RequestBody batchDto batchDto) {

		return ResponseHandler.responseBuilder("Create Batch Name !", HttpStatus.OK.value(),

				this.batchService.createBatchDto(batchDto));
	}

	@PutMapping("/{batchId}")
	public ResponseEntity<Object> updateBatchName(@RequestBody batchDto batchDto, @PathVariable Long batchId) {

		return ResponseHandler.responseBuilder("Update Batch Name !", HttpStatus.OK.value(),
				this.batchService.updateBatchDto(batchDto, batchId));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/{batchId}")
	public ResponseEntity<apiResponse> deleteBatchName(@PathVariable Long batchId) {

		this.batchService.deleteBatchName(batchId);

		return new ResponseEntity(new apiResponse("Delete Batch Name !", HttpStatus.OK.value()), HttpStatus.OK);

	}

	@GetMapping("/{batchId}")
	public ResponseEntity<Object> getBatchName(@PathVariable Long batchId) {

		return ResponseHandler.responseBuilder("Request Batch Name details are given hear", HttpStatus.OK.value(),
				this.batchService.getBatchDto(batchId));
	}

	@GetMapping("")
	public ResponseEntity<List<batchDto>> getAllBatchName() {

		return ResponseEntity.ok(this.batchService.getAllBatchDtos());
	}

}
