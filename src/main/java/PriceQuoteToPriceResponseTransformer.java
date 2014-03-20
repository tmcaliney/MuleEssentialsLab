import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transformer.TransformerException;

import com.mulesoft.training.pricing.PriceOffer;
import com.mulesoft.training.pricing.PriceRequest;
import com.mulesoft.training.pricing.PriceResponse;

import edu.emory.mathcs.backport.java.util.Collections;

public class PriceQuoteToPriceResponseTransformer implements Callable {

	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		// CopyOnWriteArrayList<PriceOffer> priceOffers =
		// (CopyOnWriteArrayList<PriceOffer>) src;
		// PriceRequest requestPayload = (PriceRequest)
		// eventContext.getFlowConstruct().get
		// PriceResponse priceResponse = new PriceResponse(requestPayload);
		// priceResponse.setOffers(priceOffers);
		// return priceResponse;
		return null;
	}

	// public Object onCall(MuleEventContext eventContext, @Payload String
	// payload)
	// throws Exception {
	// String returnPath = eventContext.getMessage().getProperty("myReturnPath",
	// PropertyScope.OUTBOUND);
	//
	// }

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		PriceRequest priceRequest = (PriceRequest) eventContext.getMessage().getInvocationProperty("PriceRequest");

		@SuppressWarnings("unchecked")
		CopyOnWriteArrayList<PriceOffer> priceOffers = (CopyOnWriteArrayList<PriceOffer>) eventContext
				.getMessage().getPayload();
		
		ArrayList<PriceOffer> modifiablePriceOffers = new ArrayList<PriceOffer>(priceOffers);

		Collections.sort(modifiablePriceOffers, new Comparator<PriceOffer>() {

			@Override
			public int compare(PriceOffer priceOffer1, PriceOffer priceOffer2) {
				return priceOffer1.getPrice() - priceOffer2.getPrice();
			}
		});

		PriceResponse priceResponse = new PriceResponse(priceRequest);
		priceResponse.setOffers(new CopyOnWriteArrayList<PriceOffer>(modifiablePriceOffers));

		return priceResponse;
	}
}
