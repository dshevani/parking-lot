package com.jek.go.parkinglot.commands;

import java.util.HashMap;
import java.util.Map;

import com.jek.go.parkinglot.IParkingLotCommand;

public enum ParkingLotCommandEnum {
	
	CREATE_PARKING_LOT("create_parking_lot", CreateParkingLot.class),
	PARK("park", Park.class),
	LEAVE("leave", Leave.class),
	STATUS("status", GetStatus.class),
	REGISTRATION_NO_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_colour", GetRegistrationNumberForCarWithColor.class),
	SLOT_NO_FOR_CAR_WITH_COLOR("slot_numbers_for_cars_with_colour", GetSlotNumberForCarWithColor.class),
	SLOR_NO_FOR_REGISTRATION_NO("slot_number_for_registration_number", GetSlotNumberForCarWithRegistrationNumber.class)
	;
	String commandString;
	Class<? extends IParkingLotCommand> commandClazz;
	static Map<String, Class<? extends IParkingLotCommand>> map = new HashMap<String, Class<? extends IParkingLotCommand>>();
	
	private ParkingLotCommandEnum(String commandString, Class<? extends IParkingLotCommand> commandClazz) {
		this.commandString = commandString;
		this.commandClazz = commandClazz;
	}
	
	public static Class<? extends IParkingLotCommand> parse(String commandString) {
		if (map.isEmpty()) {
			initialize();
		}
		if (map.containsKey(commandString)) {
			return map.get(commandString);
		}
		return null;
	}
	
	private static void initialize() {
		for (ParkingLotCommandEnum command : ParkingLotCommandEnum.values()) {
			map.put(command.commandString, command.commandClazz);
		}
	}
	
}
