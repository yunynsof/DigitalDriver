package hn.com.tigo.josm.orchestrator.driver.digital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.cache.ObjectFactoryCache;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.orchestrator.driver.digital.utils.DigitalConstantsDriver;

/**
 * AbstractDriver This abstract class contains properties and features for DigitalDriver.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 16/10/2019
 */
public abstract class AbstractDriver {

	/** The Constant LOGGER. */
	protected static final Logger LOGGER = Logger
			.getLogger(AbstractDriver.class);

	/** The object factory cache. */
	protected static ObjectFactoryCache objectFactoryCache = ObjectFactoryCache
			.getInstance();

	/**  the httpDeleteService. */
	protected String httpDeleteService;

	/** The httpCreateService. */
	protected String httpCreateService;
	
	/** Attribute that determine httpTigoSportProv. */
	protected String httpTigoSportProv;
	
	/** Attribute that determine userNameDelete. */
	protected String userNameDelete;
	
	/** Attribute that determine passwordDelete. */
	protected String passwordDelete;
	
	/** Attribute that determine userNameCreate. */
	protected String userNameCreate;
	
	/** Attribute that determine passwordCreate. */
	protected String passwordCreate;
	
	/** Attribute that determine passwordTigoSport. */
	protected String passwordTigoSport;

	/** Attribute that determine taskType. */
	protected TaskRequestType taskType;

	/** Attribute that determine properties. */
	private Map<String, String> properties;

	/**
	 * Instantiates a new abstract driver.
	 */
	public AbstractDriver() {
		this.properties = new HashMap<>();
		properties.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
	}

	/**
	 * Call service.
	 *
	 * @param url the url
	 * @param method the method
	 * @param utf8 the utf 8
	 * @param user the user
	 * @param pass the pass
	 * @return the string
	 * @throws AdapterException the adapter exception
	 */
	protected String callService(final String url, final String method, final Charset utf8, final String user, final String pass)
			throws AdapterException {
		String response = "";
		try {
			String userpass = user + ":" + pass;
            String basicAuth = "Basic " + new String(Base64.encodeBase64(userpass.getBytes()));
			URL weburl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) weburl.openConnection();
			conn.setRequestProperty("Authorization", basicAuth);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			InputStreamReader in;
			if (conn.getResponseCode() == 200) {
				in = new InputStreamReader(conn.getInputStream());
			}else{
				in = new InputStreamReader(conn.getErrorStream());
			}
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				response = response + output;
			}
			conn.disconnect();
			in.close();
			br.close();
		} catch (Exception e) {
			LOGGER.error(DigitalConstantsDriver.CREATE_REQUEST_METHOD
					+ DigitalConstantsDriver.ERROR_TOKEN + e.getMessage());
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR,
					e.getMessage());
		}
		return response;
	}

	
	/**
	 * Validate service response.
	 *
	 * @param responseDriver            the response driver
	 * @return the task response type
	 * @throws AdapterException             the adapter exception
	 */
	protected TaskResponseType validateResponse(
			final TaskResponseType responseDriver) throws AdapterException {
		if (responseDriver.getResponseCode() != 0) {
			LOGGER.error(responseDriver.getResponseDescription());
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR,
					responseDriver.getResponseDescription(),
					String.valueOf(responseDriver.getResponseCode()), null);
		}

		return responseDriver;
	}

	/**
	 * Creates the response.
	 *
	 * @param responseCode
	 *            the response code
	 * @param responseDescription
	 *            the response description
	 * @param param
	 *            the param
	 * @return the task response type
	 */
	protected TaskResponseType createDriverToAdapterResponse(
			final String responseCode, final String responseDescription,
			final ParameterArray param) {
		final TaskResponseType response = new TaskResponseType();
		response.setResponseCode(Integer.parseInt(responseCode));
		response.setResponseDescription(responseDescription);
		response.setParameters(param);
		return response;
	}


	/**
	 * Builds the new parameter for the ParameterArray class.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the parameter type
	 */
	protected ParameterType buildNewParameter(final String name,
			final String value) {
		final ParameterType parameter = new ParameterType();
		parameter.setName(name);
		parameter.setValue(value);
		return parameter;
	}

	/**
	 * Method that allows to execute a specific driver.
	 *
	 * @return the task response type
	 * @throws AdapterException
	 *             the adapter exception
	 */
	public abstract TaskResponseType execute() throws AdapterException;

	
	/**
	 * Post.
	 *
	 * @param endpoint the endpoint
	 * @param password the password
	 * @param request the request
	 * @return the string
	 * @throws AdapterException the adapter exception
	 */
	protected String post(final String endpoint, final String password, final String request) throws AdapterException {
		HttpConnectorPost post = null;
		String response = null;
		try {
			properties.put(HttpHeaders.AUTHORIZATION, "Basic " + password);
			post = new HttpConnectorPost(endpoint, properties);
			response = post.invoke(request, StandardCharsets.UTF_8);
		} catch (HttpClientException e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, e.getMessage(),
					String.valueOf(AdapterErrorCode.COMMUNICATION_ERROR), null);
		}
		return response;
	}

	
	/**
	 * Creates the response.
	 *
	 * @param responseCode the response code
	 * @param responseDescription the response description
	 * @param param the param
	 * @return the task response type
	 */
	protected TaskResponseType createResponse(final int responseCode, final String responseDescription,
			final ParameterArray param) {
		final TaskResponseType response = new TaskResponseType();
		response.setResponseCode(responseCode);
		response.setResponseDescription(responseDescription);
		response.setParameters(param);
		return response;
	}

	/**
	 * Gets the parameter.
	 *
	 * @param value the value
	 * @param constants the constants
	 * @return the parameter
	 */
	public static ParameterType getParameter(final String value, final String constants) {

		ParameterType parameterResponse = new ParameterType();
		parameterResponse.setName(constants);
		parameterResponse.setValue(value);
		return parameterResponse;
	}

	/**
	 * Sets the http delete service.
	 *
	 * @param httpDeleteService            the httpDeleteService to set
	 */
	public final void setHttpDeleteService(String httpDeleteService) {
		this.httpDeleteService = httpDeleteService;
	}


	/**
	 * Sets the http create service.
	 *
	 * @param httpCreateService            the httpCreateService to set
	 */
	public final void setHttpCreateService(String httpCreateService) {
		this.httpCreateService = httpCreateService;
	}

	/**
	 * Sets the user name delete.
	 *
	 * @param userNameDelete the userNameDelete to set
	 */
	public final void setUserNameDelete(String userNameDelete) {
		this.userNameDelete = userNameDelete;
	}


	/**
	 * Sets the password delete.
	 *
	 * @param passwordDelete the passwordDelete to set
	 */
	public final void setPasswordDelete(String passwordDelete) {
		this.passwordDelete = passwordDelete;
	}

	/**
	 * Gets the user name create.
	 *
	 * @return the userNameCreate
	 */
	public final String getUserNameCreate() {
		return userNameCreate;
	}

	/**
	 * Sets the user name create.
	 *
	 * @param userNameCreate the userNameCreate to set
	 */
	public final void setUserNameCreate(String userNameCreate) {
		this.userNameCreate = userNameCreate;
	}


	/**
	 * Sets the password create.
	 *
	 * @param passwordCreate the passwordCreate to set
	 */
	public final void setPasswordCreate(String passwordCreate) {
		this.passwordCreate = passwordCreate;
	}


	/**
	 * Sets the http tigo sport prov.
	 *
	 * @param httpTigoSportProv the new http tigo sport prov
	 */
	public void setHttpTigoSportProv(String httpTigoSportProv) {
		this.httpTigoSportProv = httpTigoSportProv;
	}

	
	/**
	 * Sets the password tigo sport.
	 *
	 * @param passwordTigoSport the new password tigo sport
	 */
	public void setPasswordTigoSport(String passwordTigoSport) {
		this.passwordTigoSport = passwordTigoSport;
	}
	
	
}
