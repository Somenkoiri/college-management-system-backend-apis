package com.college.ms.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.ms.entities.CollageName;
import com.college.ms.exceptions.ResourceNotFound;
import com.college.ms.payloads.collageNameDto;
import com.college.ms.respositores.collageNameRepo;
import com.college.ms.services.collageNameService;

@Service
public class collageNameServiceImp implements collageNameService {

	@Autowired
	private collageNameRepo collageNameRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public collageNameDto createCollageNameDto(collageNameDto collageNameDto) {

		CollageName collageName = this.dtoTOCollageName(collageNameDto);
		CollageName saveCollageName = this.collageNameRepo.save(collageName);

		return this.collageNameToDto(saveCollageName);
	}

	@Override
	public collageNameDto updateCollageNameDto(collageNameDto collageNameDto, Long collageId) {

		CollageName collageName = this.collageNameRepo.findById(collageId)
				.orElseThrow(() -> new ResourceNotFound("CollageName", "CollageId", collageId));

		collageName.setCollageName(collageNameDto.getCollageName());

		CollageName updateCollageName = this.collageNameRepo.save(collageName);
		collageNameDto collageNameDto1 = this.collageNameToDto(updateCollageName);
		return collageNameDto1;
	}

	@Override
	public collageNameDto getCollageNameDto(Long collageId) {

		CollageName collageName = this.collageNameRepo.findById(collageId)
				.orElseThrow(() -> new ResourceNotFound("CollageName", "CollageId", collageId));

		return this.collageNameToDto(collageName);
	}

	@Override
	public List<collageNameDto> getAllCollageNameDtos() {

		List<CollageName> collageNames = this.collageNameRepo.findAll();
		List<collageNameDto> collageNameDtos = collageNames.stream()
				.map((collageName) -> this.collageNameToDto(collageName)).collect(Collectors.toList());
		return collageNameDtos;
	}

	@Override
	public void deleteCollageNameDto(Long collageId) {
		CollageName collageName = this.collageNameRepo.findById(collageId)
				.orElseThrow(() -> new ResourceNotFound("CollageName", "CollageId", collageId));

		this.collageNameRepo.delete(collageName);

	}

	// Type Create Convert ( DTO and collageName )

	// CollageName To DTO

	public CollageName dtoTOCollageName(collageNameDto collageNameDto) {

		CollageName collageName = this.modelMapper.map(collageNameDto, CollageName.class);
		return collageName;
	}

	// DTO To CollageName

	public collageNameDto collageNameToDto(CollageName collageName) {

		collageNameDto collageNameDto = this.modelMapper.map(collageName, collageNameDto.class);

		return collageNameDto;
	}

}
