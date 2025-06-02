package com.college.ms.exceptions;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
public class ResourceNotFound extends RuntimeException {

	private String fieldResource;
	private String fieldName;
	private Long fieldValue;

	public ResourceNotFound(String fieldResource, String fieldName, Long fieldValue) {
		super(String.format("Data Not Found !", fieldResource, fieldName, fieldValue));
		this.fieldResource = fieldResource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
