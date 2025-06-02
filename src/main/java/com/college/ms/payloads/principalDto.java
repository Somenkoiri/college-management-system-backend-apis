package com.college.ms.payloads;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class principalDto {

	private Long principalId;
	
	@NotEmpty(message = "Principal name is empty !")
	private String principalName;
	
	@NotEmpty(message = "Email must not be empty !")
    @Email(message = "Email should be valid !")
	private String principalEmail;

    @NotEmpty(message = "Password must not be empty !")
    @Size(min = 0, max = 15 , message = "Password must be at least 15 characters !")
	private String principalPassword;

    private collageNameDto collageName;

}
