package com.cs348.crud.repositories;

import com.cs348.crud.entities.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClubRepository implements ClubRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public int save(Club club) throws Exception{

        jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
        System.out.println("Transcation Level 1: Read Uncommitted ");
        System.out.println("Transcation Level 2: Read Committed ");
        System.out.println("Transcation Level 3: Repeatable Read ");
        System.out.println("Transaction Level 4 : Serializable");

        System.out.println();
        System.out.println();

        System.out.println("Our Project Transcation Level " +jdbcTemplate.getDataSource().getConnection().getTransactionIsolation() + " Serializable");
        return jdbcTemplate.update("insert into clubs (name, address, description) values (?, ?, ?)",
               club.getName(), club.getAddress(), club.getDescription());
    }
    @Override
    @Transactional
    public int update(Club club) throws Exception {
        jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
        return jdbcTemplate.update("update clubs set name = ?, address = ?, description = ? where id = ?",
                club.getName(), club.getAddress(), club.getDescription(), club.getId());
    }
    @Override
    @Transactional
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

