package com.spring_boot.spring_boot.Learn.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring_boot.spring_boot.Learn.DepartmentNotFoundException;
import com.spring_boot.spring_boot.Learn.entity.Department;
import com.spring_boot.spring_boot.Learn.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	 	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDept");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDeptList() {
		LOGGER.info("Inside saveDept");
		return departmentService.fetchDeptList();
	}
	
	@GetMapping("/departments/{Id}")
	public Department fetchDeptById(@PathVariable("Id") Long departmentId) 
									throws DepartmentNotFoundException {
		return departmentService.fetchDeptById(departmentId);
	}
	
	@DeleteMapping("/departments/{Id}")
	public String deleteDeptById(@PathVariable("Id") Long departmentId) {
		departmentService.deleteDeptById(departmentId);
		return "Deleted Successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,
										@RequestBody Department department) {
		return departmentService.updateDepartmemnt(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDeptByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDeptByName(departmentName);
	}
}
