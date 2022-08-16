package org.pjp.api.holiday.model;

import java.util.List;

/**
 * Class which comprises a list of bank holidays for a country.
 * @author Paul
 *
 */
public final class Country {

    private Division division;

    private List<Event> events;

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


}
