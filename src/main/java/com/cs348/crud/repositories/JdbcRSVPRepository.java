package com.cs348.crud.repositories;
import com.cs348.crud.entities.RSVPReport;
import com.cs348.crud.entities.RSVPSearchForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class JdbcRSVPRepository implements RSVPReportRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String query = "select m.time, m.duration, m.description as meeting_description, \n" +
            "c.name as club_name, c.description as club_description, \n" +
            "r.building, r.number, r.maxCapacity, \n" +
            "s.name as student_name, s.email, \n" +
            "rs.invitation_date, rs.reply_date, rs.replyType, rs.comment from meetings m, \n" +
            "clubs c, \n" +
            "rooms r, \n" +
            "students s, \n" +
            "rsvp rs, \n" +
            "meetingorganizers mo\n" +
            "where rs.meeting_id = m.id and \n" +
            "m.id = mo.meeting_id and \n" +
            "m.club_id = c.id and\n" +
            "m.room_id = r.id and\n" +
            "rs.student_id = s.student_id and\n" +
            "s.student_id = mo.student_id";
    public List<RSVPReport> generateReport(){
        return jdbcTemplate.query(query, (rs, rowNum) -> new RSVPReport(
                rs.getString("student_name"),
                rs.getString("email"),
                rs.getString("building"),
                rs.getInt("number"),
                rs.getInt("maxCapacity"),
                rs.getString("club_name"),
                rs.getString("club_description"),
                rs.getTimestamp("time"),
                rs.getInt("duration"),
                rs.getString("meeting_description"),
                rs.getDate("invitation_date"),
                rs.getDate("reply_date"),
                rs.getString("replyType"),
                rs.getString("comment")
                )
        );
    }
    public List<RSVPReport> generateReport(RSVPSearchForm rsvpSearchForm){
        String queryString = query;
        if(!StringUtils.isEmpty(rsvpSearchForm.getStudentName())) {
            queryString += " and s.name like '%" +rsvpSearchForm.getStudentName() + "%'";
        }
        if(!StringUtils.isEmpty(rsvpSearchForm.getEmail())) {
            queryString += " and s.email = '" +rsvpSearchForm.getEmail() + "'";
        }
        if(!StringUtils.isEmpty(rsvpSearchForm.getClubName())) {
            queryString += " and c.name like '%" +rsvpSearchForm.getClubName() + "%'";
        }
        if(!StringUtils.isEmpty(rsvpSearchForm.getBuilding())) {
            queryString += " and r.building like '%" +rsvpSearchForm.getBuilding() + "%'";
        }
        return jdbcTemplate.query(queryString, (rs, rowNum) -> new RSVPReport(
                        rs.getString("student_name"),
                        rs.getString("email"),
                        rs.getString("building"),
                        rs.getInt("number"),
                        rs.getInt("maxCapacity"),
                        rs.getString("club_name"),
                        rs.getString("club_description"),
                        rs.getTimestamp("time"),
                        rs.getInt("duration"),
                        rs.getString("meeting_description"),
                        rs.getDate("invitation_date"),
                        rs.getDate("reply_date"),
                        rs.getString("replyType"),
                        rs.getString("comment")
                )
        );
    }


}
