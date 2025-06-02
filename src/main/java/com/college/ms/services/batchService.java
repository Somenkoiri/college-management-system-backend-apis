package com.college.ms.services;

import java.util.List;

import com.college.ms.payloads.batchDto;

public interface batchService {

	batchDto createBatchDto(batchDto batchDto);

	batchDto updateBatchDto(batchDto batchDto, Long batchId);

	batchDto getBatchDto(Long batchId);

	List<batchDto> getAllBatchDtos();

	void deleteBatchName(Long batchId);
}
