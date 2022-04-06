package com.example.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer>{
	 List<Employee> findEmployeesByName(String name);
     Employee findById(int id);
}
