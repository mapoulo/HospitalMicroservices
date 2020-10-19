package com.example.demo.models;

import java.util.List;

public class DeseaseList {
	
	List<Diseases> deseasList;
	

	public DeseaseList() {
	}
	
	public DeseaseList(List<Diseases> deseasList) {
		this.deseasList = deseasList;
	}

	public List<Diseases> getDeseasList() {
		return deseasList;
	}

	public void setDeseasList(List<Diseases> deseasList) {
		this.deseasList = deseasList;
	}
	

}
