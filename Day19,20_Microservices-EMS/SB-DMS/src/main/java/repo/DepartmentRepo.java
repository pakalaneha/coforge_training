package com.coforge.dms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.dms.model.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	
}
