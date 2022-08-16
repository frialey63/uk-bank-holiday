package org.pjp.api.holiday;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pjp.api.holiday.model.BankHolidays;
import org.pjp.api.holiday.model.Division;
import org.pjp.api.holiday.model.Event;

/**
 * Class contains queries for bank holidays, it caches the dataset obtained from the API.
 * @author Paul
 *
 */
public final class QueryUtil {

    private static class SingletonHolder {
        public static final QueryUtil instance = new QueryUtil();
    }

    /**
     * @return The singleton instance
     */
    public static QueryUtil getInstance() {
        return SingletonHolder.instance;
    }

    private final RestClient client = new RestClient();

    private BankHolidays bankHolidays;

    /**
     * @param division The Division
     * @param date The date
     * @return True if the date within the Division is a bank holiday
     */
    public boolean isHoliday(Division division, LocalDate date) {
        return getBankHolidays().getCountry(division).getEvents().stream().filter(e -> date.equals(e.getDate())).findFirst().isPresent();
    }

    /**
     * @param division The Division
     * @param year The year
     * @param title The title of the bank holiday
     * @return Optional containing the date for the specified bank holiday if valid otherwise empty
     */
    public Optional<LocalDate> getDate(Division division, int year, String title) {
        return getBankHolidays().getCountry(division).getEvents().stream().filter(e -> title.equals(e.getTitle()) && (year == e.getDate().getYear())).map(Event::getDate).findFirst();
    }

    /**
     * @param division The Division
     * @param year The year
     * @return List of all bank holidays within the Division for the year
     */
    public List<Event> getHolidays(Division division, int year) {
        return getBankHolidays().getCountry(division).getEvents().stream().filter(e -> (year == e.getDate().getYear())).collect(Collectors.toList());
    }

    /**
     * Force refresh of the cached dataset, if "Christmas Day" lookup fails then this may be required
     */
    public synchronized void refresh() {
        bankHolidays = null;
    }

    private QueryUtil() {
        // prevent instantiation
    }

    private synchronized BankHolidays getBankHolidays() {
        if (bankHolidays == null) {
            bankHolidays = client.getBankHolidays();
        }

        return bankHolidays;
    }
}
