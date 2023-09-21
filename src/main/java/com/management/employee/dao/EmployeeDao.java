package com.management.employee.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.management.employee.entity.Employee;
import com.management.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeerespository;

	public String getDeleted() {
		employeerespository.deleteAll();
		;
		return "successfully deleted";
	}

	public List<Employee> getsaved(List<Employee> r) {
		return employeerespository.saveAll(r);
	}

	public Employee getsaveded(Employee t) {
		return employeerespository.save(t);
	}

	public List<Employee> getonevalue() {
		return employeerespository.findAll();
	}

	public Optional<Employee> getonebyid(int num) {
		return employeerespository.findById(num);
	}

	

	public Optional<Employee> getonedeleted(int id) {
		return employeerespository.findById(id);
	}
	public List<Employee> getBySalary(int a, int b) {
		return employeerespository.getBySalary(a, b);
}

	public List<Employee> getAllEmp() {
	
		return employeerespository.findAll();
	}
	public List<Employee> getQuery(int c){
		return employeerespository.getQuery(c);
	}



	


}
