package com.cs348.crud.entities;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
public class RSVPReport {
    private String studentName;
    @Email
    private String email;
    private String building;
    @NotNull
    private int buildingNumber;
    @NotNull
    private int maxCapacity;
    private String clubName;
    private String clubDescription;
    private Timestamp meetingTime;
    @NotNull
    private int duration;
    private String meetingDescription;
    private Date invitationDate;
    private Date replyDate;
    private String replyType;
    private String comment;
    public RSVPReport() {}
    public RSVPReport(String studentName, String email, String building,
                      int buildingNumber, int maxCapacity, String clubName,
                      String clubDescription, Timestamp meetingTime, int duration, String meetingDescription,
                      Date invitationDate, Date replyDate,
                      String replyType, String comment){
        this.studentName = studentName;
        this.email = email;
        this.building = building;
        this.buildingNumber = buildingNumber;
        this.maxCapacity = maxCapacity;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.meetingTime = meetingTime;
        this.duration = duration;
        this.meetingDescription = meetingDescription;
        this.invitationDate = invitationDate;
        this.replyDate = replyDate;
        this.replyType = replyType;
        this.comment = comment;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getBuilding(){
        return this.building;
    }
    public int getBuildingNumber(){
        return this.buildingNumber;
    }
    public int getMaxCapacity(){
        return this.maxCapacity;
    }
    public String getClubName(){
        return this.clubName;
    }
    public String getClubDescription(){
        return this.clubDescription;
    }
    public Timestamp getMeetingTime(){
        return this.meetingTime;
    }
    public Date getInvitationDate(){
        return this.invitationDate;
    }
    public Date getReplyDate(){
        return this.replyDate;
    }
    public String getMeetingDescription(){
        return this.meetingDescription;
    }
    public String getReplyType(){
        return this.replyType;
    }
    public String getComment(){
        return this.comment;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setBuilding(String building){
        this.building = building;
    }
    public void setBuildingNumber(int buildingNumber){
        this.buildingNumber = buildingNumber;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }
    public void setClubName(String clubName){
        this.clubName = clubName;
    }
    public void setClubDescription(String clubDescription){
        this.clubDescription = clubDescription;
    }
    public void setMeetingTime(Timestamp meetingTime){
        this.meetingTime = meetingTime;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "RSVPReport{" +
                "studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", building='" + building + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", maxCapacity=" + maxCapacity +
                ", clubName='" + clubName + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", meetingTime=" + meetingTime +
                ", duration=" + duration +
                ", meetingDescription='" + meetingDescription + '\'' +
                ", invitationDate=" + invitationDate +
                ", replyDate=" + replyDate +
                ", replyType='" + replyType + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public void setMeetingDescription(String meetingDescription){
        this.meetingDescription = meetingDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RSVPReport)) return false;

        RSVPReport that = (RSVPReport) o;

        if (getBuildingNumber() != that.getBuildingNumber()) return false;
        if (getMaxCapacity() != that.getMaxCapacity()) return false;
        if (getDuration() != that.getDuration()) return false;
        if (!getStudentName().equals(that.getStudentName())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (!getBuilding().equals(that.getBuilding())) return false;
        if (!getClubName().equals(that.getClubName())) return false;
        if (!getClubDescription().equals(that.getClubDescription())) return false;
        if (!getMeetingTime().equals(that.getMeetingTime())) return false;
        if (!getMeetingDescription().equals(that.getMeetingDescription())) return false;
        if (!getInvitationDate().equals(that.getInvitationDate())) return false;
        if (!getReplyDate().equals(that.getReplyDate())) return false;
        if (!getReplyType().equals(that.getReplyType())) return false;
        return getComment().equals(that.getComment());
    }

    @Override
    public int hashCode() {
        int result = getStudentName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getBuilding().hashCode();
        result = 31 * result + getBuildingNumber();
        result = 31 * result + getMaxCapacity();
        result = 31 * result + getClubName().hashCode();
        result = 31 * result + getClubDescription().hashCode();
        result = 31 * result + getMeetingTime().hashCode();
        result = 31 * result + getDuration();
        result = 31 * result + getMeetingDescription().hashCode();
        result = 31 * result + getInvitationDate().hashCode();
        result = 31 * result + getReplyDate().hashCode();
        result = 31 * result + getReplyType().hashCode();
        result = 31 * result + getComment().hashCode();
        return result;
    }

    public void setInvitationDate(Date invitationDate){
        this.invitationDate = invitationDate;
    }
    public void setReplyDate(Date replyDate){
        this.replyDate = replyDate;
    }
    public void setReplyType(String replyType){
        this.replyType = replyType;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}
