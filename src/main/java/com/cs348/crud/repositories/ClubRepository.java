package com.cs348.crud.repositories;

import com.cs348.crud.entities.Club;

import java.util.List;
import java.util.Optional;

public interface ClubRepository {
    int save(Club club) throws Exception;
    int update(Club club) throws Exception;
    int deleteById(Integer id);
    List<Club> findAll();
    Optional<Club> findById(Integer id);
}

