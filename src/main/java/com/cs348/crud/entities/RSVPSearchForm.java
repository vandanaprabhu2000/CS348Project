package com.cs348.crud.entities;

public class RSVPSearchForm {
    public String getStudentName() {
        return this.studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getEmail() {
        return email;
    }

    public RSVPSearchForm(String studentName, String email, String clubName, String building) {
        this.studentName = studentName;
        this.email = email;
        this.clubName = clubName;
        this.building = building;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RSVPSearchForm)) return false;

        RSVPSearchForm that = (RSVPSearchForm) o;

        if (getStudentName() != null ? !getStudentName().equals(that.getStudentName()) : that.getStudentName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getClubName() != null ? !getClubName().equals(that.getClubName()) : that.getClubName() != null)
            return false;
        return getBuilding() != null ? getBuilding().equals(that.getBuilding()) : that.getBuilding() == null;
    }

    @Override
    public int hashCode() {
        int result = getStudentName() != null ? getStudentName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getClubName() != null ? getClubName().hashCode() : 0);
        result = 31 * result + (getBuilding() != null ? getBuilding().hashCode() : 0);
        return result;
    }

    public String getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "RSVPSearchForm{" +
                "studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", clubName='" + clubName + '\'' +
                ", building='" + building + '\'' +
                '}';
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    private String studentName = "";
    private String email = "";
    private String clubName = "";
    private String building = "";
}