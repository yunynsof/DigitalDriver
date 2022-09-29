package hn.com.tigo.josm.orchestrator.digital.driver.test;

import javax.ejb.embeddable.EJBContainer;

import org.apache.log4j.Logger;

import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.orchestrator.driver.digital.DigitalDriver;


/**
 * AbstractTest.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 09-27-2022 09:30:24 AM 2022
 */
public class AbstractTest {

	/** Attribute that determine container. */
	protected static EJBContainer container;

	/** Attribute that determine driver. */
	protected static DigitalDriver driver;

	/** Attribute that determine a Constant of LOGGER. */
	protected static final transient Logger LOGGER = Logger.getLogger(AbstractTest.class);

	final String digitalServiceDelete = "https://testapi.tigo.com.hn/mobile/tigo/hn/digital/offers/additional/v1/subscriber/%s/offerId/%s/consumer/%s";

	final String digitalServiceCreate = "https://testapi.tigo.com.hn/mobile/tigo/hn/digital/amazonOffer/v1/addOffer/consumer/%s/msisdn/%s/plan/%s/subscriberType/%s/offerId/%s";

	final String userNameDelete = "ApiCPEUser";

	final String passwordDelete = "Tig02021&";

	final String userNameCreate = "ApiCPEUser";

    final String passwordCreate = "Tig02021&";
	
	/** Attribute that determine endpoint. */
	final String tigoSportProvisioning = "https://testapi.tigo.com.hn/mobile/tigo/hn/digital/app/sport/subscription/consumer/37";
	
	/** Attribute that determine password. */
	final String passwordTigoSport = "QXBpRGlnaXRhbFVzZXI6VGlnMDIwMTgh";

	/**
	 * Instantiates a new abstract test.
	 *
	 * @throws AdapterException the adapter exception
	 */
	public AbstractTest() throws AdapterException {
		container = EjbContainerContext.INSTANCE.getContainer();
		driver = new DigitalDriver(digitalServiceDelete, digitalServiceCreate, userNameDelete, passwordDelete, userNameCreate, passwordCreate, tigoSportProvisioning, passwordTigoSport);
	}

}
