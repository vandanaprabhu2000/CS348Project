package com.cs348.crud.repositories;
import com.cs348.crud.entities.Student;

import java.util.List;
import java.util.Optional;
public interface StudentRepository {
    int save(Student student) throws Exception;
    int update(Student student) throws Exception;
    int deleteById(Integer id);
    List<Student> findAll();
    Optional<Student> findById(Integer id);
}

