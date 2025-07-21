package com.spring_boot.spring_boot.Learn.service;

import java.util.List;
import com.spring_boot.spring_boot.Learn.DepartmentNotFoundException;
import com.spring_boot.spring_boot.Learn.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDeptList();

	public Department fetchDeptById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDeptById(Long departmentId);

	public Department updateDepartmemnt(Long departmentId, Department department);

	public Department fetchDeptByName(String departmentName);
}
