package org.pjp.api.holiday.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum which represents a division (aka named country).
 * @author Paul
 *
 */
public enum Division {
    @JsonProperty("england-and-wales")
    ENGLAND_AND_WALES,
    @JsonProperty("scotland")
    SCOTLAND,
    @JsonProperty("northern-ireland")
    NORTHERN_IRELAND;
}
