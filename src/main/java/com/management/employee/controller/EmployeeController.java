package com.management.employee.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.Employee;
import com.management.employee.exceptionhandler.AgeNotEligible;
import com.management.employee.exceptionhandler.NameNotFoundException;
import com.management.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;

	@DeleteMapping(value = "/deleteall")
	public String getDeleted() {
		return employeeservice.getDeleted();
	}

	@PostMapping(value = "/saveall")
	public List<Employee> getsaved(@RequestBody List<Employee> r) {
		return employeeservice.getsaved(r);
	}

	@PostMapping(value = "/savein")
	public Employee getsaveded(@RequestBody Employee t) {
		return employeeservice.getsaveded(t);
	}

	@GetMapping(value = "/getonevalue")
	public List<Employee> getonevalue() {
		return employeeservice.getonevalue();
	}
	@GetMapping(value="/getonebyid/{num}")
	public Optional<Employee> getonebyid(@PathVariable int num) {
	return employeeservice.getonebyid(num);
	}
	@PutMapping(value="getonedeleted/{id}")
	public Optional<Employee> getonedeleted(@PathVariable int id) {
		return employeeservice.getonedeleted(id);
	}
	@GetMapping(value="/getBySalary/{a}/{b}")
	public List<Employee> getBySalary(@PathVariable int a,@PathVariable int b){
		return employeeservice.getBySalary(a,b);
	}
	@GetMapping(value="/getAllEmp")
	public List<Employee> getAllEmp(){
		return employeeservice.getAllEmp();
	}
	@GetMapping(value="/getcon/{age}")
	public List<Employee> getAllEmpByAge(@PathVariable int age){
		return employeeservice.getAllEmpByAge(age);
	}
	@GetMapping(value="/getmax")
		public Employee getmax() {
			return employeeservice.getmax();
		}
	@GetMapping(value="/getQuery/{c}")
	public List<Employee> getQuery(@PathVariable int c){
		return employeeservice.getQuery(c);
	}
	@PostMapping(value="/getexpection")
	public String getexpection(@RequestBody Employee s) throws AgeNotEligible{
		return employeeservice.getexpection(s);
	}
	@GetMapping(value="/getbyname")
	public List<String> getbyname(){
		return employeeservice.getbyname();
	}
	@GetMapping(value="/getByName/{name}")
	public List<Employee> geByName(@PathVariable String name)throws NameNotFoundException{
		return employeeservice.getByName(name);
	}



	
	
	
	
	
	
}
