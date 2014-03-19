package com.mulesoft.training.pricing;

public interface PricingOfferInterface {

	// Get offer
	public abstract PriceOffer getOffer(PriceRequest request) throws Exception;

}