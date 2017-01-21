package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class GetSlotNumberForCarWithRegistrationNumber implements IParkingLotCommand  {

	private String registrationNumber;
		
	public GetSlotNumberForCarWithRegistrationNumber(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 2) {
			throw new ParkingLotException("Get Slots Command syntax error");
		}
		setRegistrationNumber(arguments[1]);
	}
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		parkingSlotManager.findSlotsWithSpecificRegistrationNumberCar(registrationNumber);
		return true;
	}
	
}
