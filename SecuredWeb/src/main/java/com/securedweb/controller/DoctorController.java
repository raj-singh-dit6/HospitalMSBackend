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

import com.securedweb.dto.DoctorDto;
import com.securedweb.model.responses.CrudResponse;
import com.securedweb.model.responses.Response;
import com.securedweb.model.responses.SingleResponse;
import com.securedweb.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SingleResponse<DoctorDto> getDoctor(@PathVariable("id") Integer id) {
		SingleResponse<DoctorDto> resp = new SingleResponse<DoctorDto>();
		
		try {
			resp.setData(doctorService.getDoctor(id));
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getDoctor() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param doctorDto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse addDoctor(@RequestBody DoctorDto doctorDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			doctorService.addDoctor(doctorDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in addDoctor() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param doctorDto
	 * @return
	 */
	@PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse updateDoctor(@RequestBody DoctorDto doctorDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			doctorService.updateDoctor(doctorDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in updateDoctor() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{doctorId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse deleteDoctor(@PathVariable("id") Integer id) {
		CrudResponse resp = new CrudResponse();
		try {
			doctorService.deleteDoctor(id);;
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in deleteDoctor() ", e);
		}
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response<DoctorDto> getDoctors() {
		Response<DoctorDto> resp = new Response<DoctorDto>();
		
		try {
			resp.setData(doctorService.getDoctors());
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getDoctors() ", e);
		}
		return resp;
	}

}