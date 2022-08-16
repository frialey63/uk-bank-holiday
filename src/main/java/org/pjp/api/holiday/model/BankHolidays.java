package org.pjp.api.holiday.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class which represents the complete dataset of bank holidays, i.e. for all countries of the UK.
 * @author Paul
 *
 */
public final class BankHolidays {

    private Country englandAndWales;

    private Country scotland;

    private Country northernIreland;

    @JsonProperty("england-and-wales")
    public Country getEnglandAndWales() {
        return englandAndWales;
    }

    public void setEnglandAndWales(Country englandAndWales) {
        this.englandAndWales = englandAndWales;
    }

    @JsonProperty("scotland")
    public Country getScotland() {
        return scotland;
    }

    public void setScotland(Country scotland) {
        this.scotland = scotland;
    }

    @JsonProperty("northern-ireland")
    public Country getNorthernIreland() {
        return northernIreland;
    }

    public void setNorthernIreland(Country northernIreland) {
        this.northernIreland = northernIreland;
    }

    /**
     * @param division The division
     * @return Country for the specified division
     */
    public Country getCountry(Division division) {
        return switch(division) {
        case ENGLAND_AND_WALES -> englandAndWales;
        case SCOTLAND -> englandAndWales;
        case NORTHERN_IRELAND -> englandAndWales;
        };
    }
}
