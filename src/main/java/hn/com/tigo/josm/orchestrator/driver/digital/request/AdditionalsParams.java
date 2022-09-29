package hn.com.tigo.josm.orchestrator.driver.digital.request;

/**
 * AdditionalsParams class of type object needed to map the request.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 09-26-2022 05:03:45 PM 2022
 */
public class AdditionalsParams {

	/** Attribute that determine attribute. */
	private String attribute;

	/** Attribute that determine value. */
	private String value;

	/**
	 * Sets the attribute.
	 *
	 * @param attribute the new attribute
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Gets the attribute.
	 *
	 * @return the attribute
	 */
	public String getAttribute() {
		return this.attribute;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
