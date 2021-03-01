package com.cs348.crud.repositories;

import com.cs348.crud.entities.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClubRepository implements ClubRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Club club) throws Exception{
        return jdbcTemplate.update("insert into clubs (name, address, description) values (?, ?, ?)",
               club.getName(), club.getAddress(), club.getDescription());
    }
    @Override
    public int update(Club club) throws Exception {
        return jdbcTemplate.update("update clubs set name = ?, address = ?, description = ? where id = ?",
                club.getName(), club.getAddress(), club.getDescription(), club.getId());
    }
    @Override
    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from clubs where id = ?", id);
    }
    @Override
    public List<Club> findAll(){
        return jdbcTemplate.query("select * from clubs", (rs, rowNum) -> new Club(rs.getInt("id"),
                rs.getString("name"), rs.getString("address"), rs.getString("description")
            )
        );
    }
    public Optional<Club> findById(Integer id){
        return jdbcTemplate.queryForObject("select * from clubs where id = ?", new Object[]{id}, (rs, rowNum) ->
                Optional.of(new Club(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("description")
                ))
        );

    }
}

