package com.management.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.management.employee.dao.EmployeeDao;
import com.management.employee.entity.Employee;
import com.management.employee.exceptionhandler.AgeNotEligible;
import com.management.employee.exceptionhandler.NameNotFoundException;
import com.management.employee.repository.EmployeeRepository;

@Service

public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	EmployeeRepository employeerespository;
	
	public String getDeleted() {
		return employeeDao.getDeleted();
	}

	public List<Employee> getsaved(List<Employee> r) {
		return employeeDao.getsaved(r);
	}

	public Employee getsaveded(Employee t) {
		return employeeDao.getsaveded(t);
	}

	public List<Employee> getonevalue() {
		return employeeDao.getonevalue();
	}

	public Optional<Employee> getonebyid(int num) {
		return employeeDao.getonebyid(num);
	}

	

	public Optional<Employee> getonedeleted(int id) {
		return employeeDao.getonedeleted(id);
	}
			
	public List<Employee> getBySalary(int a,int b){
		return employeeDao.getBySalary(a,b);
	}



	public List<Employee> getAllEmpByAge(int age) {
		List<Employee> a=employeeDao.getAllEmp();
		return a.stream().filter(ty->ty.getAge()>age).collect(Collectors.toList());
		
	}

	public List<Employee> getAllEmp() {
	
		return employeeDao.getAllEmp();
	}

	public Employee getmax() {
		List<Employee> ma=getAllEmp();
		return ma.stream().max(Comparator.comparingInt(Employee::getAge)).get();
	}

	public List<Employee> getQuery(int c) {
		return employeeDao.getQuery(c);
	}

	public String getexpection(Employee s) throws AgeNotEligible{
		Employee er=getsaveded(s);
		try {if(er.getAge()>18) {
			return "successfully saved";
		}
		else {
			throw new AgeNotEligible( "not eligible");
			}
		}
		catch(Exception e) {
			return "invalid data";
		}
		}
	public List<String> getbyname() {
		List<Employee> ty=getAllEmp();
		List <String> yy=ty.stream().map(y->y.getName()).toList();
		return yy;
	}

	public List<Employee> getByName(String name)throws NameNotFoundException{
		List<String> f=getbyname();
		List<Employee> temp=employeerespository.getByName(name);
		
		if(temp.isEmpty()) {
			throw new NameNotFoundException("there is no data with this name");
		}
		else {
			return temp;
		}
	}




		
	}
	
	

	
	

