package com.cs348.crud.repositories;
import com.cs348.crud.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class JdbcRoomsRepository implements RoomsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Rooms rooms) throws Exception{
        return jdbcTemplate.update("insert into rooms (number, building, maxCapacity) values (?, ?)",
                rooms.getNumber(), rooms.getBuilding(), rooms.getMaxCapacity());
    }
    @Override
    public int update(Rooms rooms) throws Exception {
        return jdbcTemplate.update("update Rooms set number = ?, building = ?, maxCapacity = ?, where rooms_id = ?",
                rooms.getNumber(), rooms.getBuilding(), rooms.getMaxCapacity()), rooms.getId());
    }
    @Override
    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from rooms where rooms_id = ?", id);
    }
    @Override
    public List<Rooms> findAll(){
        return jdbcTemplate.query("select * from rooms", (rs, rowNum) -> new Rooms(rs.getInt("rooms_id"),
                rs.getString("number"), rs.getString("building"), rs.getString("maxCapacity");
            )
        );
    }
    public Optional<Rooms> findById(Integer id){
        return jdbcTemplate.queryForObject("select * from rooms where rooms_id = ?", new Object[]{id}, (rs, rowNum) ->
                Optional.of(new Rooms(rs.getInt("rooms_id"), rs.getString("number"), rs.getString("building"),
                        rs.getString("maxCapacity");
                ))
        );
    }
}

