package com.college.ms.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.ms.entities.Principal;
import com.college.ms.exceptions.ResourceNotFound;
import com.college.ms.payloads.principalDto;
import com.college.ms.respositores.principalRepo;
import com.college.ms.services.principalService;

@Service
public class principalServiceImp implements principalService {

	@Autowired
	private principalRepo principalRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public principalDto createPrincipalDto(principalDto principalDto) {
		Principal principal = this.dtoToPrincipal(principalDto);
		Principal savePrincipal = this.principalRepo.save(principal);
		return this.principalToDto(savePrincipal);
	}

	@Override
	public principalDto updatePrincipalDto(principalDto principalDto, Long principalId) {
		Principal principal = this.principalRepo.findById(principalId)
				.orElseThrow(() -> new ResourceNotFound("Principal", "principalId", principalId));

		principal.setPrincipalName(principalDto.getPrincipalName());
		principal.setPrincipalPassword(principalDto.getPrincipalPassword());
		principal.setPrincipalEmail(principalDto.getPrincipalEmail());
		Principal updatePrincipal = this.principalRepo.save(principal);
		principalDto principalDto1 = this.principalToDto(updatePrincipal);

		return principalDto1;
	}

	@Override
	public principalDto getPrincipalDto(Long principalId) {
		Principal principal = this.principalRepo.findById(principalId)
				.orElseThrow(() -> new ResourceNotFound("Principal", "principalId", principalId));

		return this.principalToDto(principal);
	}

	@Override
	public List<principalDto> getAllPrincipalDtos() {
		List<Principal> principals = this.principalRepo.findAll();
		List<principalDto> principalDtos = principals.stream().map((principa) -> this.principalToDto(principa))
				.collect(Collectors.toList());

		return principalDtos;
	}

	@Override
	public void deletePrincipal(Long principalId) {
		Principal principal = this.principalRepo.findById(principalId)
				.orElseThrow(() -> new ResourceNotFound("Principal", "principalId", principalId));

	   principal.setStatus(0);
	   principalRepo.save(principal);

	}

	// Type Convert

	public Principal dtoToPrincipal(principalDto principalDto) {

		Principal principal = this.modelMapper.map(principalDto, Principal.class);
		return principal;
	}

	public principalDto principalToDto(Principal principal) {

		principalDto principalDto = this.modelMapper.map(principal, principalDto.class);
		return principalDto;
	}
}
