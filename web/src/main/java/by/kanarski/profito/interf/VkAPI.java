package by.kanarski.profito.interf;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.base.Country;
import com.vk.api.sdk.objects.database.City;
import com.vk.api.sdk.objects.database.responses.GetCitiesResponse;
import com.vk.api.sdk.objects.database.responses.GetCountriesResponse;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Project: GKsolution
 * Created by: dmitry pintusov
 * Date: 25.05.17.
 */
public class VkAPI {
	private static Logger logger = Logger.getLogger(VkAPI.class);
	private final static int CLIENT_ID = 6045588;
	private final static String CLIENT_SECRET = "zHmlvwmPE9CMdSaVGqWK";
	private final static String ACCESS_TOKEN = "dacf1527dacf1527dacf1527b9da932ab3ddacfdacf152783ea91f27021d7106dba79a3";

	public static void main(String[] args) {

		/**
		 * Getting auth settings
		 * @param client_id - app id in vk
		 * @param client_secret - app key in vk
		 * @param access_token - app token in vk
		 */
		ServiceActor serviceActor = new ServiceActor(CLIENT_ID, CLIENT_SECRET, ACCESS_TOKEN);
		TransportClient transportClient = HttpTransportClient.getInstance();
		VkApiClient vkApiClient = new VkApiClient(transportClient);

		try {
			/**
			 * Getting query of countries
			 * @param serviceActor - used for auth
			 * @method needAll - choose all counties if "true"
			 * @method count - amount of results: default - 100, max - 1000
			 * @method execute - execute query request
			 */
			GetCountriesResponse response = vkApiClient
					.database()
					.getCountries(serviceActor)
					.needAll(true)
					.count(1000)
					.execute();

			List<Country> countries = response.getItems();
			for (com.vk.api.sdk.objects.base.Country country: countries) {
				/**
				 * Delete // to get all countries with id
				 */
				//System.out.printf("Country: %s%n", country.getTitle());
			}

			/**
			 * Getting query of cities
			 * @param serviceActor - used for auth
			 * @param country_id - country id (from getCountries)
			 * @method needAll - choose all cities if "true"
			 * @method count - amount of results: default - 100, max - 1000
			 * @method q - adding search
			 * @method execute - execute query request
			 */
			GetCitiesResponse responseCities = vkApiClient
					.database()
					.getCities(serviceActor, 3)
					.needAll(true)
					.count(1_000)
					.q("Ми")
					.execute();
			List<City> cities = responseCities.getItems();
			for (City city: cities) {
				System.out.printf("City: %s %s %s %b%n", city.getTitle(), city.getArea(), city.getRegion(), city.isImportant());
			}
		} catch (ApiException e) {
			logger.error(e);
		} catch (ClientException e) {
			logger.error(e);
		}
	}
}
