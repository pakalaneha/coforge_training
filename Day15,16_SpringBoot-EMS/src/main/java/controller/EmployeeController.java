package com.coforge.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

// @Controller -> returns web pages (ex:jsp)

// @RestController -> returns REST APIs (json/xml)
// @RestController -> responsebody and controller -> so every method returns automatically
// no need to annotate any method

@RestController // for restful application
@RequestMapping("/api/v1/ems")
public class EmployeeController {

	// mapping url pattern -small letters
//	@GetMapping("/welcome")
//	public String sayWelcome() {
//		return "Welcome to EMS"; 
//	}
	// to see output go to postman and do get method url - >
	// hhtp://localhost:1234/api/v1/ems/welcome

	// @Autowired //Field Injection - > use this while testing as it is faster not
	// actual testing
	private EmployeeService service;

	private Environment environment;

	// setter injection after object is created injection comes
	// constructor injection at the time of object creation injection comes

	@Autowired // constructor Injection
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	// use naming convention employees not create employee or delete employee
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		try {
			boolean status = service.saveEmployee(employee);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"), HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// for update , url pattern - > employees/{eid} {}->means value or input
	// @PathVariable -> getting from url
	// to verify go to postman http://localhost:1234/api/v1/ems/employees/501
	// and give in body raw in json format
	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee(@PathVariable int eid, @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		try {
			boolean status = service.updateEmployee(eid, employee);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"),
						HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int eid) {
		ResponseEntity<String> responseEntity = null;
		try {
			boolean status = service.deleteEmployee(eid);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.FOUND);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/employees/{eid}") // ResponseEntity<?> ? -> wild card entity -> means any type
	public ResponseEntity<?> findEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<?> responseEntity = null;
		try {
			Optional<Employee> employee = service.findEmployee(eid);
			if (!employee.isEmpty()) {
				responseEntity = new ResponseEntity<>(employee.get(), HttpStatus.FOUND);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployee() {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Employee> employees = service.findAllEmployees();
			// if(!employees.isEmpty()) {
			responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	// in url pattern we cant keep employees/{ename} because backend gets confused
	// with eid and ename cause both urls are same
	// that's why keep employees/ename/{ename}
	//verify using http://localhost:1234/api/v1/ems/employees/ename/name
	@GetMapping("/employees/ename/{ename}") // ResponseEntity<?> ? -> wild card entity
	public ResponseEntity<?> findByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Employee> employees = service.findByEname(ename);
			responseEntity = new ResponseEntity<>(employees, HttpStatus.FOUND);
		} 
		catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		}
		catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@DeleteMapping("/employees/ename/{ename}") // ResponseEntity<?> ? -> wild card entity
	public ResponseEntity<?> deleteByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;
		try {
			boolean status = service.deleteByEname(ename);
			if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.FOUND);
			}
			} 
		catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		}
		catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {
		ResponseEntity<?> responseEntity = null;
		try {
		List<Integer> eids = service.getEidsList();
		responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);
		}
		catch(Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail") , HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees/info")
	public ResponseEntity<?> getInfo() {
		ResponseEntity<?> responseEntity = null;
		try {
		String info = service.getInfo();
		responseEntity = new ResponseEntity<>(info, HttpStatus.OK);
		}
		catch(Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail") , HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
//	@GetMapping("/employees")
//	public ResponseEntity<String> findAllEmployee() {
//		ResponseEntity<String> responseEntity = null;
//		try {
//			List<Employee> employees = service.findAllEmployees();
//			//if(!employees.isEmpty()) {
//				responseEntity = new ResponseEntity<>(employees.toString(),HttpStatus.CREATED);
//		} 
//		catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.fail"),HttpStatus.BAD_REQUEST);
//		}
//	
//		return responseEntity;
//	}

}
