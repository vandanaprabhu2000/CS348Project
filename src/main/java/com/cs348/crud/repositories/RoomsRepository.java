package com.cs348.crud.repositories;
import com.cs348.crud.entities.Rooms;

import java.util.List;
import java.util.Optional;
public interface RoomsRepository {
    int save(Rooms rooms) throws Exception;
    int update(Rooms rooms) throws Exception;
    int deleteById(Integer id);
    List<Rooms> findAll();
    Optional<Rooms> findById(Integer id);
}

