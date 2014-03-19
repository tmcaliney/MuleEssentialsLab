package com.mulesoft.training.pricing;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface PricingOfferService extends PricingOfferInterface {

	// Get offer
	@WebResult(name="response", partName="response")
	public abstract PriceOffer getOffer(@WebParam(name="request", partName="request") PriceRequest request) throws Exception;
}