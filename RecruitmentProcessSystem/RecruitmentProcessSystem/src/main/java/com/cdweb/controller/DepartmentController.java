package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.Department;
import com.cdweb.service.DepartmentService;
@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/departmentList")
	public ResponseEntity<List<Department>> getAllDepartment(){
		List<Department> lst= departmentService.departmentLst();
		return ResponseEntity.ok().body(lst);
	}

}
