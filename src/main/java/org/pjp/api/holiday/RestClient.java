package org.pjp.api.holiday;

import org.pjp.api.holiday.model.BankHolidays;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

/**
 * Class is the REST client through which the API is invoked.
 * @author Paul
 *
 */
final class RestClient {

    private static final String URI = "https://www.gov.uk/bank-holidays.json";

    private Client client = ClientBuilder.newClient();

    /**
     * @return The bank holidays dataset
     */
    public BankHolidays getBankHolidays() {
        return client.target(URI).request(MediaType.APPLICATION_JSON).get(BankHolidays.class);
    }

}
