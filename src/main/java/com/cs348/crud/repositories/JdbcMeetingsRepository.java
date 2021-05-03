package com.cs348.crud.repositories;
import com.cs348.crud.entities.Meetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class JdbcMeetingsRepository implements MeetingsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Meetings meetings) throws Exception{
        return jdbcTemplate.update("insert into meetings (date, time, duration, description, club_id, room_id) " +
                        "values (?, ?, ?, ?, ?, ?)",
                meetings.getMeeting_date(), meetings.getMeeting_time(), meetings.getDuration(), meetings.getDescription(),
                meetings.getClub_id(), meetings.getRoom_id());
    }
    @Override
    public int update(Meetings meetings) throws Exception {
        return jdbcTemplate.update("update Meetings set date = ?, time = ?, duration = ?," +
                        " description = ?, club_id = ?, room_id = ?, where meeting_id = ?",
                meetings.getMeeting_date(), meetings.getMeeting_time(), meetings.getDuration(), meetings.getDescription(),
                meetings.getClub_id(), meetings.getRoom_id());
    }
    @Override
    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from meetings where meeting_id = ?", id);
    }
    @Override
    public List<Meetings> findAll(){
        return jdbcTemplate.query("select * from meetings", (rs, rowNum) -> new Meetings(rs.getInt("meetings_id"),
                        rs.getDate("date"), rs.getTimestamp("time"), rs.getInt("duration"),
                        rs.getInt("club_id"), rs.getInt("room_id"), rs.getInt("capacity"), rs.getString("description")
                )
        );
    }
    public Optional<Meetings> findById(Integer id){
        return jdbcTemplate.queryForObject("select * from meetings where meeting_id = ?", new Object[]{id}, (rs, rowNum) ->
                Optional.of(new Meetings(rs.getInt("meetings_id"),
                        rs.getDate("date"), rs.getTimestamp("time"), rs.getInt("duration"),
                        rs.getInt("club_id"), rs.getInt("room_id"), rs.getInt("capacity"), rs.getString("description")
                ))
        );
    }
}