package com.spring_boot.spring_boot.Learn.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import com.spring_boot.spring_boot.Learn.entity.Department;
import com.spring_boot.spring_boot.Learn.repo.DepartmentRepo;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockitoBean
	private DepartmentRepo departmentRepo;
	
	
	
	@BeforeEach
	void setUp() throws Exception {	
		Department department = Department.builder().departmentId(1L)
													.departmentName("IT")
													.departmentAddress("Hyderabad")
													.departmentCode("IT-101")
													.build();
		
		Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Get Data on Valid Name")
	void whenValidDeptName_DeptFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchDeptByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}
}
