package com.example.springboot.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmpService;



@RestController
public class EmpController {
	@Autowired
	private EmpService service;

	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/all")
	public List<Employee> findAllEmployees() {
		List<Employee> employeelist = service.getAllEmployees();
		Collections.sort(employeelist, new EmpNameComp());
		return service.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/update/{id}/{salary}")
	public Employee updateEmployeeSal(@RequestBody Employee employee, @PathVariable int id,
			@PathVariable double salary) {
		return service.updateEmployeeSal(employee, id, salary);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
