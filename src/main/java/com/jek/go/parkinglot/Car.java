package com.jek.go.parkinglot;

import com.jek.go.common.ITenant;

public class Car implements ITenant {

	private String registrationNumber;
	
	private String colour;
	
	public Car(String registrationNumber, String colour) {
		super();
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	@Override
	public String toString() {
		return registrationNumber;
	}
	
}
