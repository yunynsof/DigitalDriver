package hn.com.tigo.josm.orchestrator.driver.digital.operations;

import org.json.JSONObject;

import com.google.gson.Gson;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.TaskResponseType;
import hn.com.tigo.josm.common.exceptions.AdapterException;
import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.exceptions.enumerators.AdapterErrorCode;
import hn.com.tigo.josm.orchestrator.driver.digital.AbstractDriver;
import hn.com.tigo.josm.orchestrator.driver.digital.request.TigoSportsProvInput;
import hn.com.tigo.josm.orchestrator.driver.digital.utils.DigitalConstantsDriver;

/**
 * TigoSportProvisioningOperation This class contains the operational logic of the TigoSportProvisionig task.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 09-26-2022 05:04:47 PM 2022
 */
public class TigoSportProvisioningOperation extends AbstractDriver {

	/** Attribute that determine request. */
	private final TigoSportsProvInput request;

	/**
	 * Instantiates a new tigo sport provisioning operation.
	 *
	 * @param request the request
	 */
	public TigoSportProvisioningOperation(final TigoSportsProvInput request) {
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.josm.orchestrator.digital.driver.core.AbstractDriver#execute()
	 */
	@Override
	public TaskResponseType execute() throws AdapterException {
		try {
			JSONObject jsonObject;
			Gson gson = new Gson();
			String jsonRequest = gson.toJson(this.request);
			final String response = super.post(this.httpTigoSportProv, this.passwordTigoSport, jsonRequest);

			jsonObject = new JSONObject(response);
			JSONObject genResponse = jsonObject.getJSONObject("generalResponse");
			String codeResponse = genResponse.get("code").toString();
			String code;

			switch (codeResponse) {
			case "01":
				code = "200";
				break;
			case "601":
				code = "400";
				break;
			default:
				code = "500";
			}

			ParameterArray param = new ParameterArray();
			param.getParameter().add(getParameter(code, DigitalConstantsDriver.HTTP_CODE));
			param.getParameter().add(getParameter(jsonObject.toString(), DigitalConstantsDriver.PARAM_NAME_RESPONSE));

			return super.createResponse(Integer.valueOf(DigitalConstantsDriver.RESPONSE_CODE),
					DigitalConstantsDriver.RESPONSE_DESCRIPTION, param);
		} catch (HttpClientException e) {
			LOGGER.error(e.getMessage());
			throw new AdapterException(AdapterErrorCode.PLATFORM_ERROR, e.getMessage());
		}
	}
}
