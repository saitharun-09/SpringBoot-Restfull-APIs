package com.spring_boot.spring_boot.Learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring_boot.spring_boot.Learn.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
