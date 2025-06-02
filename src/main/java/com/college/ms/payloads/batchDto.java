package com.college.ms.payloads;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class batchDto {

	private Long batchNameId;

	@NotEmpty(message = "Batch name is empty !")
	private String batchName;
}
 