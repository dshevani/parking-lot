package com.jek.go.parkinglot.commands;

import com.jek.go.parkinglot.Car;
import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;

public class Leave implements IParkingLotCommand  {

	private int slotId;
	
	public Leave(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 2) {
			throw new ParkingLotException("Leave Command syntax error");
		}
		setSlotId(Integer.parseInt(arguments[1]));
	}
	
	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		parkingSlotManager.releaseResourceById(slotId);
		return true;
	}

}
