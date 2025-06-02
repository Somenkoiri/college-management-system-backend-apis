package com.college.ms.payloads;

import com.college.ms.entities.BatchName;
import com.college.ms.entities.CollageName;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class sirDto {

	private Long sirId;
	
	@NotEmpty(message = "Principal name is empty !")
	private String sirName;

	private CollageName collageName;

	private BatchName batchName;

	@NotEmpty(message = "Email must not be empty !")
    @Email(message = "Email should be valid !")
	private String sirEmail;
	
	@NotEmpty(message = "Password must not be empty !")
    @Size(min = 0, max = 15 , message = "Password must be at least 15 characters !")
	private String sirPassword;
}
