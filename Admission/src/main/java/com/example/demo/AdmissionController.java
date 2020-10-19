package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.EmployeeList;
import com.example.demo.models.HrEmployee;

@RestController
public class AdmissionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Patients>  patients = Arrays.asList(
			new Patients("P1", "S1"),
			new Patients("P2", "S2"),
			new Patients("P3", "S3")
			);
	
	@RequestMapping("/myemployees")
	public EmployeeList getEmpInHrService(){
		EmployeeList l =  restTemplate.getForObject("http://localhost:8083/employees", EmployeeList.class);
		return l;
	}
	
	@RequestMapping("/patients")
	public List<Patients> patientList(){
		return patients;
	}
	
	@RequestMapping("/patients/{id}")
	public Patients getPtientById(@PathVariable String id) {
		
		Patients p = patients.stream().filter(patient -> id.equals(patient.getName())).findAny().orElse(null);
		return p;
	}

}
