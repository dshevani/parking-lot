package com.jek.go.parkinglot;

public class ParkingLotException extends Exception {

	private static final long serialVersionUID = 1L;

	public ParkingLotException(String message) {
        super(message);
    }

    public ParkingLotException(String message, Throwable throwable) {
        super(message, throwable);
    }
	
}
