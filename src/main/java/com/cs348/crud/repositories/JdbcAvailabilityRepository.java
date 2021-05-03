package com.cs348.crud.repositories;

import com.cs348.crud.entities.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class JdbcAvailabilityRepository implements AvailabilityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Availability availability) throws Exception{
        return jdbcTemplate.update("insert into availability (meeting_date, meeting_time, room_id) values (?, ?, ?)",
                availability.getMeeting_date(), availability.getMeeting_time(), availability.getAvailability_id());
    }
    @Override
    public int update(Availability availability) throws Exception {
        return jdbcTemplate.update("update availability set meeting_date = ?, meeting_time = ?, room_id = ? where id = ?",
                availability.getMeeting_date(), availability.getMeeting_time(), availability.getRoom_id(), availability.getAvailability_id());
    }
    @Override
    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from availabilty where id = ?", id);
    }
    @Override
    public List<Availability> findAll(){
        return jdbcTemplate.query("select * from availability", (rs, rowNum) -> new Availability(rs.getInt("id"),
                        rs.getInt("room_id"), rs.getDate("meeting_date"), rs.getTimestamp("meeting_time")
                )
        );
    }
    public Optional<Availability> findById(Integer id){
        return jdbcTemplate.queryForObject("select * from availability where id = ?", new Object[]{id}, (rs, rowNum) ->
                Optional.of(new Availability(rs.getInt("id"),
                        rs.getInt("room_id"), rs.getDate("meeting_date"), rs.getTimestamp("meeting_time")
                ))
        );

    }
}
