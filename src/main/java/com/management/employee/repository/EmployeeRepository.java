package com.management.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.management.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{ 
	@Query(value="select * from employee where salary >? and salary<?",nativeQuery=true)
	
	public List<Employee> getBySalary(int a,int b);
	

	

	@Query(value="select emp from Employee  emp where emp.age>:c")
	
	public List <Employee> getQuery (@Param(value="c") int c);
	
	@Query(value="select * from employee where name=?",nativeQuery=true)
	public List<Employee> getByName(String name);
	
	@Query(value="select * from employee where age>?",nativeQuery=true)
	public List<Employee> getBySalaryIn(int sal);




	
}
