package com.coforge.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;

@Repository 
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	// to automatically create the implementation of repository employee entity and mention type of primary key -> Integer

	public List<Employee> findByEname (String ename); ///directly IOC container creates no need of definition
	public int deleteByEname (String ename);
	public List<Employee> findByDno (int dno);
	public int deleteByDno (int dno);
	
	//Custom Query Methods
	@Query("select eid from Employee")
	public List<Integer> getEids(); //whenever this method is called the above query gets executed
	
	@Query("select count(*), sum(esalary), min(esalary), max(esalary) from Employee")
	public String getInfo();
}

/*
 public interface EmployeeRepo extends JpaRepository<T, ID>{

}
 */
