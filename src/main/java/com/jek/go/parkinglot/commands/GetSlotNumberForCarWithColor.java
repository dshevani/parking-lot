package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class GetSlotNumberForCarWithColor implements IParkingLotCommand  {
	
	private String colour;
	
	public GetSlotNumberForCarWithColor(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 2) {
			throw new ParkingLotException("Park Command syntax error");
		}
		setColour(arguments[1]);
	}
	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		parkingSlotManager.findSlotsWithSpecificColorCar(colour);
		return true;
	}

}
