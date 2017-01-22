package com.jek.go.parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.jek.go.parkinglot.commands.ParkingLotCommandEnum;

public class ParkingApplication {
	
	static ParkingSlotManager parkingSlotManager = new ParkingSlotManager();

	@SuppressWarnings("resource")
	public static void main( String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ParkingLotException, FileNotFoundException {
		Scanner scanner = null;
        try {
        	String filePath = args[args.length-1];
        	Path path = Paths.get(filePath);
    		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            	// Read from file
            	File file = new File(args[args.length-1]);
            	scanner = new Scanner(file);
            } else {
            	// Interactive Session
            	scanner = new Scanner(System.in);
            }
        	while (scanner.hasNext()) {
        		processCommand(scanner.nextLine());
        	}
        }
        finally {
        	if (scanner != null) {
        		scanner.close();
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
