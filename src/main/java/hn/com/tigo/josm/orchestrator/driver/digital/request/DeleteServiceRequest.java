package hn.com.tigo.josm.orchestrator.driver.digital.request;

import java.io.Serializable;

public class DeleteServiceRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String subscriber;
	private String offerId;
	private String consumer;
	/**
	 * @return the subscriber
	 */
	public final String getSubscriber() {
		return subscriber;
	}
	/**
	 * @param subscriber the subscriber to set
	 */
	public final void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	/**
	 * @return the offerId
	 */
	public final String getOfferId() {
		return offerId;
	}
	/**
	 * @param offerId the offerId to set
	 */
	public final void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	/**
	 * @return the consumer
	 */
	public final String getConsumer() {
		return consumer;
	}
	/**
	 * @param consumer the consumer to set
	 */
	public final void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	
}
