package com.cs348.crud.repositories;

import com.cs348.crud.entities.Availability;
import com.cs348.crud.entities.Club;

import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository {
    int save(Availability availability) throws Exception;
    int update(Availability availability) throws Exception;
    int deleteById(Integer id);
    List<Availability> findAll();
    Optional<Availability> findById(Integer id);
}

