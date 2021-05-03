package com.cs348.crud.repositories;

import com.cs348.crud.entities.Meetings;
import java.util.List;
import java.util.Optional;
public interface MeetingsRepository {
    int save(Meetings meetings) throws Exception;
    int update(Meetings meetings) throws Exception;
    int deleteById(Integer id);
    List<Meetings> findAll();
    Optional<Meetings> findById(Integer id);
}
