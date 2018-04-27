package com.securedweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.securedweb.model.TestReport;

public interface TestReportRepository extends CrudRepository<TestReport, Integer>{
	
}
