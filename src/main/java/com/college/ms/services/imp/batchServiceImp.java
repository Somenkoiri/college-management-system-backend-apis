package com.college.ms.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.ms.entities.BatchName;
import com.college.ms.exceptions.ResourceNotFound;
import com.college.ms.payloads.batchDto;
import com.college.ms.respositores.batchRepo;
import com.college.ms.services.batchService;

@Service
public class batchServiceImp implements batchService {

	@Autowired
	private batchRepo batchRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public batchDto createBatchDto(batchDto batchDto) {

		BatchName batchName = this.dtoTOBatchName(batchDto);
		BatchName saveBatchName = this.batchRepo.save(batchName);

		return this.batchToBatchDto(saveBatchName);
	}

	@Override
	public batchDto updateBatchDto(batchDto batchDto, Long batchId) {
		BatchName batchName = this.batchRepo.findById(batchId)
				.orElseThrow(() -> new ResourceNotFound("Batch Name ", "BatchId", batchId));

		batchName.setBatchName(batchDto.getBatchName());
		BatchName upadeBatchDto = this.batchRepo.save(batchName);
		batchDto batchDto2 = this.batchToBatchDto(upadeBatchDto);

		return batchDto2;
	}

	@Override
	public batchDto getBatchDto(Long batchId) {
		BatchName batchName = this.batchRepo.findById(batchId)
				.orElseThrow(() -> new ResourceNotFound("Batch Name ", "BatchId", batchId));

		return this.batchToBatchDto(batchName);
	}

	@Override
	public List<batchDto> getAllBatchDtos() {
		List<BatchName> batchNames = this.batchRepo.findAll();
		List<batchDto> batchDtos = batchNames.stream().map((batchName) -> this.batchToBatchDto(batchName))
				.collect(Collectors.toList());
		return batchDtos;
	}

	@Override
	public void deleteBatchName(Long batchId) {
		BatchName batchName = this.batchRepo.findById(batchId)
				.orElseThrow(() -> new ResourceNotFound("Batch Name ", "BatchId", batchId));

		this.batchRepo.delete(batchName);

	}

	// Type Convert Batch To DTO

	public BatchName dtoTOBatchName(batchDto batchDto) {

		BatchName batchName = this.modelMapper.map(batchDto, BatchName.class);
		return batchName;
	}

	public batchDto batchToBatchDto(BatchName batchName) {

		batchDto batchDto = this.modelMapper.map(batchName, batchDto.class);
		return batchDto;

	}

}
