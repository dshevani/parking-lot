package com.jek.go.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jek.go.common.AbstractResourceManager;
import com.jek.go.common.ITenant;

public class ParkingSlotManager extends AbstractResourceManager<ParkingSlot, ITenant> {
	
	public ParkingSlotManager(Map<ParkingSlot, ITenant> parkingSlotToCarMap) {
		super(parkingSlotToCarMap);
	}
	
	public ParkingSlotManager() {
		super();
	}
	
	@Override
	public ParkingSlot getAvailableResource() {
		for (ParkingSlot slot : resourceTenantMap.keySet()) {
			if (resourceTenantMap.get(slot) instanceof NoTenant) {
				return slot;
			}
		}
		return null;
	}
	
	@Override
	public boolean bookResource(ParkingSlot resource, ITenant tenant) {
		if (resource != null && resourceTenantMap.get(resource) instanceof NoTenant) {
			resourceTenantMap.put(resource, tenant);
			System.out.println("Allocated slot number: " + resource.getId() + " to " + tenant  + "\n");
			return true;
		}
		System.out.println("Sorry, parking lot is full\n");
		return false;
	}
	
	@Override
	public boolean bookAvailableResource(ITenant tenant) {
		ParkingSlot slot = getAvailableResource();
		return bookResource(slot, tenant);
	}

	@Override
	public boolean releaseResource(ParkingSlot resource) {
		if (resourceTenantMap.get(resource) != null) {
			resourceTenantMap.put(resource, NoTenant.instance());
			System.out.println("Slot number " + resource.getId() + " is free\n");
			return true;
		}
		return false;
	}
	
	public boolean releaseResourceById(int resourceId) {
		ParkingSlot slotToBeReleased = null;
		for (ParkingSlot slot : resourceTenantMap.keySet()) {
			if (slot.getId() == resourceId) {
				slotToBeReleased = slot;
				break;
			}
		}
		if (slotToBeReleased == null) {
			return false;
		}
		return releaseResource(slotToBeReleased);
	}

	@Override
	public boolean printStatus() {
		System.out.println("Slot No.\tRegistration No\tColour");
		for (ParkingSlot slot : resourceTenantMap.keySet()) {
			if (resourceTenantMap.get(slot) instanceof Car) {
				System.out.println(slot.getId() + "\t\t" + ((Car)resourceTenantMap.get(slot)).getRegistrationNumber() + "\t\t" + ((Car)resourceTenantMap.get(slot)).getColour());
			}
		}
		System.out.println();
		return true;
	}
	
	public boolean findSlotsWithSpecificRegistrationNumberCar(String registrationNumber) {
		for (ParkingSlot slot : resourceTenantMap.keySet()) {
			ITenant tenant = resourceTenantMap.get(slot);
			if (tenant instanceof Car && ((Car) tenant).getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
				System.out.println(slot.getId() + "\n");
				return true;
			}
		}
		System.out.println("Not Found\n");
		return false;
	}
	
	public boolean findSlotsWithSpecificColorCar(String colour) {
		List<String> slotNumbers = new ArrayList<String>();
		for (ParkingSlot slot : resourceTenantMap.keySet()) {
			ITenant tenant = resourceTenantMap.get(slot);
			if (tenant instanceof Car && ((Car) tenant).getColour().equalsIgnoreCase(colour)) {
				slotNumbers.add(Integer.toString(slot.getId()));
			}
		}
		System.out.println(String.join(", ", slotNumbers));
		System.out.println();
		return true;
	}

	public boolean findCarsWithColor(String colour) {
		List<String> carRegistrationNumbers = new ArrayList<String>();
		for (ITenant tenant : resourceTenantMap.values()) {
			if (tenant instanceof Car && ((Car) tenant).getColour().equalsIgnoreCase(colour)) {
				carRegistrationNumbers.add(((Car)tenant).getRegistrationNumber());
			}
		}
		System.out.println(String.join(", ", carRegistrationNumbers));
		System.out.println();
		return true;
	}
	
}
