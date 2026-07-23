package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.dms.model.Department;

import jakarta.validation.Valid;

public interface DepartmentService {

	boolean saveDept(Department department);

	boolean updateDeptById(int dno, @Valid Department department);

	boolean deleteDeptById(int dno);

	Optional<Department> findDeptById(int dno);

	List<Department> findDepts();

}
