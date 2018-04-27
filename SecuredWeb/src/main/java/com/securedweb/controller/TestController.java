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

import com.securedweb.dto.TestDto;
import com.securedweb.model.responses.CrudResponse;
import com.securedweb.model.responses.Response;
import com.securedweb.model.responses.SingleResponse;
import com.securedweb.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
 
	@Autowired
	private TestService testService;
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SingleResponse<TestDto> getTest(@PathVariable("id") Integer id) {
		SingleResponse<TestDto> resp = new SingleResponse<TestDto>();
		
		try {
			resp.setData(testService.getTest(id));
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getTest() ", e);
		}

		return resp;
	}

	/**
	 * 
	 * @param testDto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse addTest(@RequestBody TestDto testDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			testService.addTest(testDto);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in addTest() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param occupancy
	 * @return
	 */
	@PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse updateTest(@RequestBody TestDto testDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			testService.updateTest(testDto);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in updateTest() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse deleteTest(@PathVariable("id") Integer id) {
		CrudResponse resp = new CrudResponse();
		try {
			testService.deleteTest(id);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in deleteTest() ", e);
		}
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response<TestDto> getOccupancies() {
		Response<TestDto> resp = new Response<TestDto>();
		
		try {
			resp.setData(testService.getTests());
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getOccupancies() ", e);
		}
		return resp;
	}

}