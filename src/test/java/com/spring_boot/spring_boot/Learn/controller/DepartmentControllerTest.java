package com.spring_boot.spring_boot.Learn.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.spring_boot.spring_boot.Learn.entity.Department;
import com.spring_boot.spring_boot.Learn.service.DepartmentService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSaveDepartment() throws Exception{
		Department inputDepartment = Department.builder().departmentName("IT")
														 .departmentAddress("Hyd")
														 .departmentCode("IT-101")
														 .build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType("application/json")
		        .content("{\r\n"
		                + "    \"departmentName\": \"IT\",\r\n"
		                + "    \"departmentAddress\": \"Hyderabad\",\r\n"
		                + "    \"departmentCode\": \"IT-101\"\r\n"
		                + "}"))
		        .andExpect(status().isOk());
	}

}