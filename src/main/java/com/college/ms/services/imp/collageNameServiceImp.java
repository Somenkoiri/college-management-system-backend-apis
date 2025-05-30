package com.college.ms.services.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.ms.entities.CollageName;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public collageNameDto updateCollageNameDto(collageNameDto collageNameDto, Long collageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public collageNameDto getCollageNameDto(Long collageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<collageNameDto> getAllCollageNameDtos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCollageNameDto(Long collageId) {
		// TODO Auto-generated method stub

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
