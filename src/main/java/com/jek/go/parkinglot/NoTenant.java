package com.jek.go.parkinglot;

import com.jek.go.common.ITenant;

/** Because ConcurrentHashMap doesn't allow null values **/

public class NoTenant implements ITenant {
	
	private static NoTenant instance;
	
	private NoTenant() {
		
	}
	
	public static NoTenant instance() {
		if (instance == null) {
			instance = new NoTenant();
		}
		return instance;
	}
	
}
