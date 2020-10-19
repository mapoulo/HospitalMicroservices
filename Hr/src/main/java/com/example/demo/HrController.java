package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.DeseaseList;
import com.example.demo.models.EmployeeList;

@RestController
public class HrController {

	@Autowired
	private RestTemplate restTemplate;
	
	 List<HrEmployee> employees = Arrays.asList(
			 new HrEmployee("E1", "Id1"),
			 new HrEmployee("E2", "Id2"),
			 new HrEmployee("E3", "Id3")
			 );
	 
	 
	 @RequestMapping("/employees")
	 public EmployeeList findAllEmployees(){
		EmployeeList empList = new EmployeeList();
		empList.setMyList(employees);
		return empList;
	 }
	 
	 @RequestMapping("/diseases")
	 public DeseaseList getDeseaseList() {
		 DeseaseList l = restTemplate.getForObject("http://localhost:8082/diseases/", DeseaseList.class);
		 return l;
	 }
	
	 
	 
	 @RequestMapping("/employees/{id}")
	 public HrEmployee findEmployeeById(@PathVariable String id) {
		 HrEmployee employee = employees.stream().filter(emp -> id.equals(emp.getId())).findAny().orElse(null);
		 return employee;
	 }
}
