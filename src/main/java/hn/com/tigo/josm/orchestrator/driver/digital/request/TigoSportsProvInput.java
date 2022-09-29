package hn.com.tigo.josm.orchestrator.driver.digital.request;

import java.util.List;

/**
 * TigoSportsProvInput This model class is used for the TigoSportProvisioning object.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 09-26-2022 05:03:52 PM 2022
 */
public class TigoSportsProvInput {
	
	/** Attribute that determine transactionId. */
	private String transactionId;

	/** Attribute that determine dateEvent. */
	private String dateEvent;

	/** Attribute that determine duration. */
	private int duration;

	/** Attribute that determine productId. */
	private int productId;

	/** Attribute that determine orderType. */
	private String orderType;

	/** Attribute that determine eventType. */
	private String eventType;

	/** Attribute that determine additionalsParams. */
	private List<AdditionalsParams> additionalsParams;

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return this.transactionId;
	}

	/**
	 * Sets the date event.
	 *
	 * @param dateEvent the new date event
	 */
	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	/**
	 * Gets the date event.
	 *
	 * @return the date event
	 */
	public String getDateEvent() {
		return this.dateEvent;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId() {
		return this.productId;
	}

	/**
	 * Sets the order type.
	 *
	 * @param orderType the new order type
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public String getOrderType() {
		return this.orderType;
	}

	/**
	 * Sets the event type.
	 *
	 * @param eventType the new event type
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * Gets the event type.
	 *
	 * @return the event type
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 * Sets the additionals params.
	 *
	 * @param additionalsParams the new additionals params
	 */
	public void setAdditionalsParams(List<AdditionalsParams> additionalsParams) {
		this.additionalsParams = additionalsParams;
	}

	/**
	 * Gets the additionals params.
	 *
	 * @return the additionals params
	 */
	public List<AdditionalsParams> getAdditionalsParams() {
		return this.additionalsParams;
	}
}
