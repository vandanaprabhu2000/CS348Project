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
@Table(name = "Meetings")
public class Meetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meeting_id;
    private Date meeting_date;
    private Timestamp meeting_time;
    private int duration;
    private int club_id;
    private int room_id;
    private int capacity;
    private String description;
    public int getMeeting_id() {
        return meeting_id;
    }
    public Date getMeeting_date() {
        return meeting_date;
    }
    @NotNull
    @Size(min = 2, max = 30)
    public Timestamp getMeeting_time() {
        return meeting_time;
    }
    @Size(min = 5, max = 100)
    public int getDuration() {
        return duration;
    }
    @NotNull
    public int getClub_id() {
        return club_id;
    }
    public int getRoom_id() {
        return room_id;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getDescription() {
        return description;
    }
    @NotNull
    @Size(min = 2, max = 100)

    public Meetings() {

    }
    public Meetings(int meeting_id, Date meeting_date, Timestamp meeting_time, int duration, int club_id, int room_id, int capacity, String description) {
        this.meeting_id = meeting_id;
        this.meeting_date = meeting_date;
        this.meeting_time = meeting_time;
        this.duration = duration;
        this.club_id = club_id;
        this.room_id = room_id;
        this.capacity = capacity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "meeting_id=" + meeting_id +
                ", meeting_date=" + meeting_date +
                ", meeting_time=" + meeting_time +
                ", duration=" + duration +
                ", club_id=" + club_id +
                ", room_id=" + room_id +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meetings)) return false;
        Meetings meetings = (Meetings) o;

        return getMeeting_id() == meetings.getMeeting_id() &&
                getDuration() == meetings.getDuration() &&
                getClub_id() == meetings.getClub_id() &&
                getRoom_id() == meetings.getRoom_id() &&
                getCapacity() == meetings.getCapacity() &&
                Objects.equals(getMeeting_date(), meetings.getMeeting_date()) &&
                Objects.equals(getMeeting_time(), meetings.getMeeting_time()) &&
                Objects.equals(getDescription(), meetings.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getMeeting_id();
        result = 31 * result + getDuration();
        result = 31 * result + getClub_id();
        result = 31 * result + getRoom_id();
        result = 31 * result + getCapacity();
        result = 31 * result + getMeeting_date().hashCode();
        result = 31 * result + getMeeting_time().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }
    public void setMeeting_date(Date meeting_date) {
        this.meeting_date = meeting_date;
    }
    public void setMeeting_time(Timestamp meeting_time) {
        this.meeting_time = meeting_time;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}