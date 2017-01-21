package com.jek.go.parkinglot.commands;

import java.util.LinkedHashMap;
import java.util.Map;

import com.jek.go.common.ITenant;
import com.jek.go.parkinglot.IParkingLotCommand;
import com.jek.go.parkinglot.NoTenant;
import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlot;
import com.jek.go.parkinglot.ParkingSlotManager;

public class CreateParkingLot implements IParkingLotCommand {

	private int size;
	
	public CreateParkingLot(String[] arguments) throws ParkingLotException {
		if (arguments == null || arguments.length != 2) {
			throw new ParkingLotException("Create Command syntax error");
		}
		setSize(Integer.parseInt(arguments[1]));
	}
	
	public boolean execute(ParkingSlotManager parkingSlotManager) throws ParkingLotException {
		Map<ParkingSlot, ITenant> parkingSlotToCarMap = new LinkedHashMap<ParkingSlot, ITenant>();
		for (int i = 1; i <= size; i++) {
			ParkingSlot p = new ParkingSlot(i);
			parkingSlotToCarMap.put(p, NoTenant.instance());
		}
		parkingSlotManager.setResourceTenantMap(parkingSlotToCarMap);
		System.out.println("Created a parking lot with " + size + " slots\n");
		return true;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
