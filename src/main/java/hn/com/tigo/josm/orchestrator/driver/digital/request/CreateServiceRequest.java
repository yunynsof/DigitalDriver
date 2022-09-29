package hn.com.tigo.josm.orchestrator.driver.digital.request;

import java.io.Serializable;

public class CreateServiceRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String consumer;
	private String msisdn;
	private String plan;
	private String subscriberType;
	private String offerId;
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
	/**
	 * @return the msisdn
	 */
	public final String getMsisdn() {
		return msisdn;
	}
	/**
	 * @param msisdn the msisdn to set
	 */
	public final void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	/**
	 * @return the plan
	 */
	public final String getPlan() {
		return plan;
	}
	/**
	 * @param plan the plan to set
	 */
	public final void setPlan(String plan) {
		this.plan = plan;
	}
	/**
	 * @return the subscriberType
	 */
	public final String getSubscriberType() {
		return subscriberType;
	}
	/**
	 * @param subscriberType the subscriberType to set
	 */
	public final void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
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

}
