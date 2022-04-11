package com.tenable.gift.utility;

import java.util.UUID;

public class IDGeneratorUtility {
	
	
	public static String generateID() {
		
		return UUID.randomUUID().toString();
	}

}
