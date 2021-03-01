package com.cs348.crud.repositories;
import com.cs348.crud.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class JdbcStudentRepository implements StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Student student) throws Exception{
        return jdbcTemplate.update("insert into students (name, email) values (?, ?)",
                student.getName(), student.getEmail());
    }
    @Override
    public int update(Student student) throws Exception {
        return jdbcTemplate.update("update Students set name = ?, email = ? where student_id = ?",
                student.getName(), student.getEmail(), student.getId());
    }
    @Override
    public int deleteById(Integer id){
        return jdbcTemplate.update("delete from students where student_id = ?", id);
    }
    @Override
    public List<Student> findAll(){
        return jdbcTemplate.query("select * from students", (rs, rowNum) -> new Student(rs.getInt("student_id"),
                rs.getString("name"), rs.getString("email")
            )
        );
    }
    public Optional<Student> findById(Integer id){
        return jdbcTemplate.queryForObject("select * from students where student_id = ?", new Object[]{id}, (rs, rowNum) ->
                Optional.of(new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email")
                ))
        );
    }
}

