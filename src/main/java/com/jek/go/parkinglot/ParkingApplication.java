package com.jek.go.parkinglot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import com.jek.go.parkinglot.commands.ParkingLotCommandEnum;

public class ParkingApplication {
	
	static ParkingSlotManager parkingSlotManager = new ParkingSlotManager();

	public static void main( String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ParkingLotException {
        if (args.length == 1) {
        	// Read from file
        	
        } else {
        	// Interactive Session
        	Scanner scanner = new Scanner(System.in);
        	while (scanner.hasNext()) {
        		processCommand(scanner.nextLine());
        	}
        }
    }

	private static void processCommand(String line)
			throws NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			ParkingLotException {
		String[] lineArray = line.split(" ");
		Class<? extends IParkingLotCommand> commandClass = ParkingLotCommandEnum.parse(lineArray[0]);
		Constructor<?> constructor = commandClass.getConstructor(String[].class);
		IParkingLotCommand command = commandClass.cast(constructor.newInstance(new Object[]{lineArray}));
		boolean result = command.execute(parkingSlotManager);
	}
}
