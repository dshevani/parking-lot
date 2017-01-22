package com.jek.go;

import com.jek.go.parkinglot.ParkingLotException;
import com.jek.go.parkinglot.ParkingSlotManager;
import com.jek.go.parkinglot.commands.CreateParkingLot;
import com.jek.go.parkinglot.commands.Park;

import junit.framework.TestCase;

public class ParkingSlotManagerTest extends TestCase {

	private ParkingSlotManager parkingSlotManager;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parkingSlotManager = new ParkingSlotManager();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCreateParkingArea() {
		try {
			CreateParkingLot command = new CreateParkingLot(new String[] { "create_parking_lot", "6" });
			boolean createParkingSlotResult = command.execute(parkingSlotManager); 
			assertTrue(createParkingSlotResult);
		} catch (ParkingLotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testParkCar() {
		try {
			CreateParkingLot createCommand = new CreateParkingLot(new String[] { "create_parking_lot", "1" });
			createCommand.execute(parkingSlotManager); 
			Park parkCommand = new Park(new String[] { "park", "KA­01­HH­1234", "White" });
			boolean parkCarResult = parkCommand.execute(parkingSlotManager); 
			assertTrue(parkCarResult);
		} catch (ParkingLotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
