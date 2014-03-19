package com.mulesoft.training.pricing;


public abstract class PriceOffering implements PricingOfferInterface {
	
	protected String airline;	

	// Get offer
	/* (non-Javadoc)
	 * @see com.mulesoft.training.pricing.PricingOfferInterface#getOffer(com.mulesoft.training.pricing.PriceRequest)
	 */
	@Override
	public PriceOffer getOffer(PriceRequest request) throws Exception{
		
		// Create offer for this airline, but without price
		PriceOffer offer = new PriceOffer(airline);
		
		// Set the offer price, getting a price via subclass getPrice methods
        offer.setPrice(this.getPrice(request.getDestination(), request.getOrigin()));
		
		// Return offer
		return offer;
	}
    
    // Get price
    // Implemented in subclasses
	protected abstract int getPrice(String destination, String origin) throws Exception;
	
}
