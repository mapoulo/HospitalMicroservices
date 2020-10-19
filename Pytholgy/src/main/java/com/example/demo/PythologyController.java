package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PythologyController {
	
	
	List<Diseases> diseases = Arrays.asList(
			new Diseases("D1", "Id1"),
			new Diseases("D2", "Id2"),
			new Diseases("D3", "Id3")
			);
	
	
	@RequestMapping("/diseases")
	public DeseaseList findAllDeseases(){
		DeseaseList d = new DeseaseList();
		d.setDeseasList(diseases);
		return d;
	}
	
	
	@RequestMapping("/diseases/{id}")
	public Diseases findDesease(@PathVariable String id) {
		Diseases disease = diseases.stream().filter(the_disease -> id.equals(the_disease.getName())).findAny().orElse(null);
		return disease;
	}

}
