package com.securedweb.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securedweb.dto.DepartmentDto;
import com.securedweb.model.Department;
import com.securedweb.repository.DepartmentRepository;


@Service("departmentService")
public class DepartmentService {	
		
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ModelMapper mapper;
	
	public List<DepartmentDto> getDepartments() {
		List<Department> hospList=(List<Department>)departmentRepository.findAll();
		List<DepartmentDto> hospDTOList = new ArrayList<DepartmentDto>();
		for(Department department:hospList)
		{
			hospDTOList.add(mapper.map(department, DepartmentDto.class));
		}
		return hospDTOList;
	}

	public DepartmentDto getDepartment(Integer id) {
		return mapper.map(departmentRepository.findById(id),DepartmentDto.class);
	}
	
	
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		departmentRepository.save(mapper.map(departmentDto,Department.class));
		return departmentDto;
	}
	
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		Department department= departmentRepository.findById(departmentDto.getId()).get();
		return departmentDto;
	}
	
	public void deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);
	}

}
