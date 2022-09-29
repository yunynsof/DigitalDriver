package hn.com.tigo.josm.orchestrator.driver.digital;

import java.util.Map;

import hn.com.tigo.josm.common.exceptions.HttpClientException;
import hn.com.tigo.josm.common.http.Buildable;
import hn.com.tigo.josm.common.http.PoolingBuilder;
import hn.com.tigo.josm.common.http.PostMethod;
import hn.com.tigo.josm.orchestrator.driver.digital.utils.DigitalConstantsDriver;

import javax.ws.rs.core.Response;

/**
 * HttpConnectorPost This class is used to call the post method from the commons project.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-16-2022 05:29:55 AM 2022
 */
public class HttpConnectorPost extends PostMethod<String> {

	/** Property that exposes the methods for obtaining the specifically configuration and of the HTTP builders instances. */
	private static Buildable buildable = PoolingBuilder.getInstance(DigitalConstantsDriver.CONFIG_NAME);


	/**
	 * Instantiates a new http connector post.
	 *
	 * @param url the url
	 * @param properties the properties
	 */
	public HttpConnectorPost(final String url, final Map<String, String> properties) {
		super(DigitalConstantsDriver.STATIC_URL, url, buildable, properties);
	}

	/* (non-Javadoc)
	 * @see hn.com.tigConstantsDriver.STATIC_URLo.josm.common.http.ServiceInvoker#getResponse(java.lang.String, int, java.lang.String)
	 */
	@Override
	public String getResponse(final String response, final int responseCode, final String responseMessage) {
		if (responseCode == Response.Status.OK.getStatusCode()
				|| responseCode == Response.Status.NOT_FOUND.getStatusCode()
				|| responseCode == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
			return response;
		}
		throw new HttpClientException(response);
	}
}