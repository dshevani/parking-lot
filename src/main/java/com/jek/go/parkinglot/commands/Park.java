package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.Car;
import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class Park implements IParkingLotCommand  {

	private String registrationNumber;
	
	private String colour;
	
	public Park(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 3) {
			throw new ParkingLotException("Park Command syntax error");
		}
		setRegistrationNumber(arguments[1]);
		setColour(arguments[2]);
	}
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		Car car = new Car(registrationNumber, colour); 
		parkingSlotManager.bookAvailableResource(car);
		return true;
	}

}
