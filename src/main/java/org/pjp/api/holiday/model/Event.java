package org.pjp.api.holiday.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * Class which represents an individual Bank Holiday (event).
 * @author Paul
 *
 */
public final class Event {

    private String title;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String notes;

    private String bunting;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBunting() {
        return bunting;
    }

    public void setBunting(String bunting) {
        this.bunting = bunting;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Event [title=");
        builder.append(title);
        builder.append(", date=");
        builder.append(date);
        builder.append(", notes=");
        builder.append(notes);
        builder.append(", bunting=");
        builder.append(bunting);
        builder.append("]");
        return builder.toString();
    }

}
