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

import com.securedweb.dto.RoomDto;
import com.securedweb.model.responses.CrudResponse;
import com.securedweb.model.responses.Response;
import com.securedweb.model.responses.SingleResponse;
import com.securedweb.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
 
	@Autowired
	private RoomService roomService;
	
	private static final Logger LOG = LoggerFactory.getLogger(RoomController.class);

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SingleResponse<RoomDto> getRoom(@PathVariable("id") Integer id) {
		SingleResponse<RoomDto> resp = new SingleResponse<RoomDto>();
		
		try {
			resp.setData(roomService.getRoom(id));
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getRoom() ", e);
		}

		return resp;
	}

	/**
	 * 
	 * @param roomDto
	 * @return
	 */
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse addRoom(@RequestBody RoomDto roomDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			roomService.addRoom(roomDto);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in addRoom() ", e);
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
	public CrudResponse updateRoom(@RequestBody RoomDto roomDto) {
		CrudResponse resp = new CrudResponse();
		
		try {
			roomService.updateRoom(roomDto);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in updateRoom() ", e);
		}
		return resp;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CrudResponse deleteRoom(@PathVariable("id") Integer id) {
		CrudResponse resp = new CrudResponse();
		try {
			roomService.deleteRoom(id);
			resp.setSuccess(true);
		} catch (Exception e) {
			LOG.error("Exception in deleteRoom() ", e);
		}
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Response<RoomDto> getOccupancies() {
		Response<RoomDto> resp = new Response<RoomDto>();
		
		try {
			resp.setData(roomService.getRooms());
			resp.setSuccess(true);
		} catch (Exception e) {

			LOG.error("Exception in getOccupancies() ", e);
		}
		return resp;
	}

}