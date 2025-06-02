package com.college.ms.services;

import java.util.List;

import com.college.ms.payloads.principalDto;

public interface principalService {

	principalDto createPrincipalDto(principalDto principalDto);

	principalDto updatePrincipalDto(principalDto principalDto, Long principalId);

	principalDto getPrincipalDto(Long principalId);

	List<principalDto> getAllPrincipalDtos();

	void deletePrincipal(Long principalId);

}
