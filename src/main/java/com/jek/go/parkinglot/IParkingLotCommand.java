package com.jek.go.parkinglot;

public interface IParkingLotCommand {

	boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException;
	
}
