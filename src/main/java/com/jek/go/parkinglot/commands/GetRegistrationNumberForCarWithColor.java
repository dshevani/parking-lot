package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class GetRegistrationNumberForCarWithColor implements IParkingLotCommand  {
	
	private String color;
	
	public GetRegistrationNumberForCarWithColor(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 2) {
			throw new ParkingLotException("Get Resitration Numbers Command syntax error");
		}
		setColor(arguments[1]);
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		parkingSlotManager.findCarsWithColor(color);
		return true;
	}

}
