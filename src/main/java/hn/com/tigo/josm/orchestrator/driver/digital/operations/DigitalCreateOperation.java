package hn.com.tigo.josm.orchestrator.driver.digital.operations;

import java.nio.charset.StandardCharsets;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.orchestrator.driver.digital.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.digital.request.CreateServiceRequest;
import hn.com.tigo.josm.orchestrator.driver.digital.utils.DigitalConstantsDriver;

/**
 * When an external system invokes this interface, the DigitalRequest is
 * executed. This interface is used
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 14/03/2021
 */
public class DigitalCreateOperation extends AbstractDriver{

	/** Attribute that determine request. */
	private final CreateServiceRequest request;
	

	/**
	 * Instantiates a new digital create operation.
	 *
	 * @param request the request
	 */
	public DigitalCreateOperation(final CreateServiceRequest request) {
		this.request = request;
	}
	
	
	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.orchestrator.driver.digital.AbstractDriver#execute()
	 */
	@Override
	public TaskResponseType execute() throws AdapterException {
		TaskResponseType responseDriver = null;
		final ParameterArray parameterArray = new ParameterArray();
		try{
			String url = String.format(this.httpCreateService, request.getConsumer(), request.getMsisdn(), request.getPlan(), request.getSubscriberType(), request.getOfferId());
			final String result = callService(url, "POST", StandardCharsets.UTF_8, this.getUserNameCreate(), this.passwordCreate);
			parameterArray.getParameter().add(buildNewParameter(DigitalConstantsDriver.JSON_RESPONSE, result));
			responseDriver = createDriverToAdapterResponse(String.valueOf(DigitalConstantsDriver.CODE_SUCCESSFUL),
					DigitalConstantsDriver.TITLE_SUCCESSFUL, parameterArray);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new AdapterException(AdapterErrorCode.COMMUNICATION_ERROR, DigitalConstantsDriver.ERROR_MESSAGE);

		}
		validateResponse(responseDriver);
		return responseDriver;
	}
}
