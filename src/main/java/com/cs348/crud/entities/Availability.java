package com.cs348.crud.entities;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availability_id;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    private int room_id;
    private Date meeting_date;

    private Timestamp meeting_time;
    private boolean available;

    public Date getMeeting_date() {
        return meeting_date;
    }
    public Timestamp getMeeting_time() {
        return meeting_time;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setMeeting_date(Date meeting_date) {
        this.meeting_date = meeting_date;
    }

    public void setMeeting_time(Timestamp meeting_time) {
        this.meeting_time = meeting_time;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability)) return false;

        Availability that = (Availability) o;

        if (getAvailability_id() != that.getAvailability_id()) return false;
        if (isAvailable() != that.isAvailable()) return false;
        if (!getMeeting_date().equals(that.getMeeting_date())) return false;
        return getMeeting_time().equals(that.getMeeting_time());
    }

    @Override
    public int hashCode() {
        int result = getAvailability_id();
        result = 31 * result + getMeeting_date().hashCode();
        result = 31 * result + getMeeting_time().hashCode();
        result = 31 * result + (isAvailable() ? 1 : 0);
        return result;
    }

    public Availability() {
    }

    public Availability( int availability_id, int room_id, Date meeting_date, Timestamp meeting_time) {
        this.availability_id = availability_id;
        this.room_id = room_id;
        this.meeting_date = meeting_date;
        this.meeting_time = meeting_time;
    }

    public int getAvailability_id() {
        return availability_id;
    }

    public void setAvailability_id(int availability_id) {
        this.availability_id = availability_id;
    }
}
