/**
 * 
 */
package com.mulesoft.training.pricing;

/**
 * @author MuleSoft Training
 * 
 */
public class PriceOfferingUnited extends PriceOffering {

	public PriceOfferingUnited() {
		this.airline ="United";
	}

	protected int getPrice(String destination, String origin) throws AirportNotFoundException {
		System.out.println("IN PriceOfferingUnited:  "+destination+" "+origin);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		int price;
		// Set United prices based on destination
		if (destination.equalsIgnoreCase("SFO")) {
			price = 420;
		} else if (destination.equalsIgnoreCase("LAX")) {
			price = 520;
		} else if (destination.equalsIgnoreCase("SEA")) {
			price = 620;
		} else {
			throw new AirportNotFoundException(destination + " Destination not found");
		}
		

		// Increment United prices based on origin
		if (price > 0) {
			if (origin.equalsIgnoreCase("YYZ")) {
				price = price + 152;
			} else if (origin.equalsIgnoreCase("ORD")) {
				price = price + 52;
			} else if (origin.equalsIgnoreCase("SQL")) {
				price = price + -102;
			} else {
				throw new AirportNotFoundException(origin + " Origin not found");
			}
		}

		System.out.println("EXITING PriceOfferingUnited: "+destination+" "+origin+" "+price);
		return price;
	}
}
