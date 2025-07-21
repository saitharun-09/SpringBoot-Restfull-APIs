package com.spring_boot.spring_boot.Learn.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.spring_boot.spring_boot.Learn.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@DataJpaTest
class DepartmentRepoTest {

	@Autowired
	private DepartmentRepo departmentRepo; 		
	
	@PersistenceContext
	private EntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentName("Civil")
													.departmentAddress("Hyd")
													.departmentCode("CE-107")
													.build();
		
		entityManager.persist(department);
	}

	@Test
	public void findById_ReturnDept() {
		Department department = departmentRepo.findById(1L).get();
		assertEquals(department.getDepartmentName(), "Civil");
	}

}
