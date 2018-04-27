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

import com.securedweb.dto.DepartmentDto;
import com.securedweb.model.responses.CrudResponse;
import com.securedweb.model.responses.Response;
import com.securedweb.model.responses.SingleResponse;
import com.securedweb.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SingleResponse<DepartmentDto> getDepartment(@PathVariable("id") Integer id) {
		SingleResponse<DepartmentDto> resp = new SingleResponse<DepartmentDto>();
		try {
			resp.setData(departmentService.getDepartment(id));
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getDepartment() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param departmentDto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse addDepartment(@RequestBody DepartmentDto departmentDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			departmentService.addDepartment(departmentDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in addDepartment() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param departmentDto
	 * @return
	 */
	@PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse updateDepartment(@RequestBody DepartmentDto departmentDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			departmentService.updateDepartment(departmentDto);
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in updateDepartment() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{departmentId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse deleteDepartment(@PathVariable("id") Integer id) {
		CrudResponse resp = new CrudResponse();
		try {
			departmentService.deleteDepartment(id);;
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in deleteDepartment() ", e);
		}
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response<DepartmentDto> getDepartments() {
		Response<DepartmentDto> resp = new Response<DepartmentDto>();
		try {
			resp.setData(departmentService.getDepartments());
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getDepartments() ", e);
		}
		return resp;
	}

}