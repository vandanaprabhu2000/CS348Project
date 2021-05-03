package com.cs348.crud.service;
import com.cs348.crud.entities.Student;
import com.cs348.crud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void addtoStudents(Student s) throws Exception {
        studentRepository.save(s);
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Integer id){
        return studentRepository.findById(id);
    }
    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
    public void deleteStudent(Student s){
        studentRepository.deleteById(s.getId());
    }
     public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
