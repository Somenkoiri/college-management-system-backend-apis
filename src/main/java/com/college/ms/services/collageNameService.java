package com.college.ms.services;

import java.util.List;

import com.college.ms.payloads.collageNameDto;

public interface collageNameService {

	collageNameDto createCollageNameDto(collageNameDto collageNameDto);

	collageNameDto updateCollageNameDto(collageNameDto collageNameDto, Long collageId);

	collageNameDto getCollageNameDto(Long collageId);

	List<collageNameDto> getAllCollageNameDtos();

	void deleteCollageNameDto(Long collageId);
}
