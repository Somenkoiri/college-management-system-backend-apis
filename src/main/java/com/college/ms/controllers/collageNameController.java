package com.college.ms.controllers;

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
import com.college.ms.payloads.collageNameDto;
import com.college.ms.services.collageNameService;

@RestController
@RequestMapping("/collageName")
public class collageNameController {

	@Autowired
	private collageNameService collageNameService;

	// POST
	@PostMapping("")
	public ResponseEntity<Object> createCollageName(@RequestBody collageNameDto collageNameDto) {

		return ResponseHandler.responseBuilder("Create Collage Name !", HttpStatus.OK.value(),
				this.collageNameService.createCollageNameDto(collageNameDto));
	}

	// PUT
	@PutMapping("/{collageId}")
	public ResponseEntity<Object> updateCollageName(@RequestBody collageNameDto collageNameDto,
			@PathVariable Long collageId) {

		return ResponseHandler.responseBuilder("Update Collage Name !", HttpStatus.OK.value(),
				this.collageNameService.updateCollageNameDto(collageNameDto, collageId));
	}

	// DELETE

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/{collageId}")
	public ResponseEntity<apiResponse> deleteCollageName(@PathVariable Long collageId) {

		this.collageNameService.deleteCollageNameDto(collageId);
		return new ResponseEntity(new apiResponse("Collage Name Delete !!", HttpStatus.OK.value()), HttpStatus.OK);
	}

	// GET
	@GetMapping("/{collageId}")
	public ResponseEntity<Object> getCollageName(@PathVariable Long collageId) {

		return ResponseHandler.responseBuilder("Request Collage Name details are given hear", HttpStatus.OK.value(),
				this.collageNameService.getCollageNameDto(collageId));
	} 

	// GET ALL
	@GetMapping("")
	public ResponseEntity<java.util.List<collageNameDto>> getAllCollageName() {

		return ResponseEntity.ok(this.collageNameService.getAllCollageNameDtos());
	}

}
