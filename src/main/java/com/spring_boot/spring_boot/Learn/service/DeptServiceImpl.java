package com.spring_boot.spring_boot.Learn.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring_boot.spring_boot.Learn.DepartmentNotFoundException;
import com.spring_boot.spring_boot.Learn.entity.Department;
import com.spring_boot.spring_boot.Learn.repo.DepartmentRepo;

@Service
public class DeptServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> fetchDeptList() {
		return departmentRepo.findAll();
	}

	@Override
	public Department fetchDeptById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> dept =  departmentRepo.findById(departmentId);
		if (!dept.isPresent()) {
			throw new DepartmentNotFoundException("Dept Not Found");
		};
		return dept.get();
	}

	@Override
	public void deleteDeptById(Long departmentId) {
		departmentRepo.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmemnt(Long departmentId, Department department) {
		Department deptDB = departmentRepo.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && 
				!"".equalsIgnoreCase(department.getDepartmentName())){
			deptDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())){
			deptDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())){
			deptDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepo.save(deptDB);
	}

	@Override
	public Department fetchDeptByName(String departmentName) {
		return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
	}
	
}
