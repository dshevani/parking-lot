package com.jek.go.parkinglot;

import com.jek.go.common.IResource;

public class ParkingSlot implements IResource {
	private int id;
	public ParkingSlot(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
