package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;
import com.example.springboot.repo.EmpRepository;

@Service
public class EmpService {
	@Autowired
	private EmpRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id);
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee removed successfully !" + id;
	}

	public Employee updateEmployeeSal(Employee employee, int id, double salary) {
		Employee existingEmployee = repository.findById(employee.getId());
		existingEmployee.setSalary(employee.getSalary());
		return repository.save(existingEmployee);
	}

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
}

