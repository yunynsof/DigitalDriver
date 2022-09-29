package hn.com.tigo.josm.orchestrator.driver.digital;

import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;

import java.util.HashMap;
import java.util.Map;



/**
 * The Class DigitalDriver is a Driver Project which contains objects based on
 * service rest objects and is used to create an object to invoke.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 14/03/2021
 */
public class DigitalDriver{
		
	/** the httpDeleteService. */
	private String httpDeleteService;
	
	/** The httpCreateService. */
	private String httpCreateService;
	
	/** Attribute that determine httpTigoSportProv. */
	private String httpTigoSportProv;
	
	/** Attribute that determine userNameDelete. */
	private String userNameDelete;
	
	/** Attribute that determine passwordDelete. */
	private String passwordDelete;
	
	/** Attribute that determine userNameCreate. */
	private String userNameCreate;
	
	/** Attribute that determine passwordCreate. */
	private String passwordCreate;
	
	/** Attribute that determine passwordTigoSport. */
	private String passwordTigoSport;
	
	

	/**
	 * Instantiates a new digital driver.
	 *
	 * @param httpDeleteService the http delete service
	 * @param httpCreateService the http create service
	 * @param userNameDelete the user name delete
	 * @param passwordDelete the password delete
	 * @param userNameCreate the user name create
	 * @param passwordCreate the password create
	 * @param tigoSportProvisioning the tigo sport provisioning
	 * @param passwordTigoSport the password tigo sport
	 * @throws AdapterException the adapter exception
	 */
	public DigitalDriver(final String httpDeleteService, final String httpCreateService, final String userNameDelete,
			final String passwordDelete, final String userNameCreate, final String passwordCreate, final String tigoSportProvisioning, final String passwordTigoSport)
			throws AdapterException {
		super();
		final Map<String, String> httpProperties = new HashMap<>();
		httpProperties.put("Content-Type", "application/json; charset=utf-8");
		httpProperties.put("Connection", "Keep-Alive");
		this.httpDeleteService = httpDeleteService;
		this.httpCreateService = httpCreateService;
		this.httpTigoSportProv = tigoSportProvisioning;
		this.userNameDelete = userNameDelete;
		this.passwordDelete = passwordDelete;
		this.userNameCreate = userNameCreate;
		this.passwordCreate = passwordCreate;
		this.passwordTigoSport = passwordTigoSport;
	}

	
	/**
	 * Execute driver.
	 *
	 * @param abstractDriver the abstract driver
	 * @return the task response type
	 * @throws AdapterException the adapter exception
	 */
	public TaskResponseType executeDriver(final AbstractDriver abstractDriver) throws AdapterException {
		abstractDriver.setHttpDeleteService(httpDeleteService);
		abstractDriver.setHttpCreateService(httpCreateService);
		abstractDriver.setHttpTigoSportProv(httpTigoSportProv);
		abstractDriver.setUserNameDelete(userNameDelete);
		abstractDriver.setUserNameCreate(userNameCreate);
		abstractDriver.setPasswordCreate(passwordCreate);
		abstractDriver.setPasswordDelete(passwordDelete);
		abstractDriver.setPasswordTigoSport(passwordTigoSport);
		
		return abstractDriver.execute();
	}
	
}
