package com.securedweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securedweb.dto.PatientDto;
import com.securedweb.model.responses.CrudResponse;
import com.securedweb.model.responses.Response;
import com.securedweb.model.responses.SingleResponse;
import com.securedweb.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SingleResponse<PatientDto> getPatient(@PathVariable("id") Integer id) {
		SingleResponse<PatientDto> resp = new SingleResponse<PatientDto>();
		resp.setSuccess(false);
		try {
			resp.setData(patientService.getPatient(id));
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getPatient() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param patientDto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse addPatient(@RequestBody PatientDto patientDto) {
		CrudResponse resp = new CrudResponse();
		resp.setSuccess(false);
		try {
			patientService.addPatient(patientDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in addPatient() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param patientDto
	 * @return
	 */
	@PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse updatePatient(@RequestBody PatientDto patientDto) {
		CrudResponse resp = new CrudResponse();
		resp.setSuccess(false);
		try {
			patientService.updatePatient(patientDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in updatePatient() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{patientId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse deletePatient(@PathVariable("id") Integer id) {
		CrudResponse resp = new CrudResponse();
		try {
			patientService.deletePatient(id);;
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in deletePatient() ", e);
		}
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response<PatientDto> getPatients() {
		Response<PatientDto> resp = new Response<PatientDto>();
		resp.setSuccess(false);
		try {
			resp.setData(patientService.getPatients());
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getPatients() ", e);
		}
		return resp;
	}

}