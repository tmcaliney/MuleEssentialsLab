package com.mulesoft.training.pricing;

public class PricingOfferServiceImpl implements PricingOfferInterface {

	@Override
	public PriceOffer getOffer(PriceRequest request) throws Exception {
		return new PriceOfferingDelta().getOffer(request);
	}

}
