package com.securedweb.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securedweb.dto.PatientStatusDto;
import com.securedweb.model.PatientStatus;
import com.securedweb.repository.PatientStatusRepository;


@Service("patientStatusService")
public class PatientStatusService {	
		
	private static final Logger LOG = LoggerFactory.getLogger(PatientStatusService.class);

	@Autowired
	PatientStatusRepository patientStatusRepository;
	
	@Autowired
	ModelMapper mapper;
	
	public List<PatientStatusDto> getPatientStatuses() {
		List<PatientStatus> hospList=(List<PatientStatus>)patientStatusRepository.findAll();
		List<PatientStatusDto> hospDTOList = new ArrayList<PatientStatusDto>();
		for(PatientStatus patientStatus:hospList)
		{
			hospDTOList.add(mapper.map(patientStatus, PatientStatusDto.class));
		}
		return hospDTOList;
	}

	public PatientStatusDto getPatientStatus(Integer id) {
		return mapper.map(patientStatusRepository.findById(id),PatientStatusDto.class);
	}
	
	
	public PatientStatusDto addPatientStatus(PatientStatusDto patientStatusDto) {
		patientStatusRepository.save(mapper.map(patientStatusDto,PatientStatus.class));
		return patientStatusDto;
	}
	
	public PatientStatusDto updatePatientStatus(PatientStatusDto patientStatusDto) {
		PatientStatus patientStatus= patientStatusRepository.findById(patientStatusDto.getId()).get();
		return patientStatusDto;
	}
	
	public void deletePatientStatus(Integer id) {
		patientStatusRepository.deleteById(id);
	}

}
