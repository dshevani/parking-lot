package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class GetStatus implements IParkingLotCommand  {

	public GetStatus(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 1) {
			throw new ParkingLotException("Status Command syntax error");
		}
	}
	
	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		parkingSlotManager.printStatus();
		return true;
	}

}
