package com.cs348.crud.controllers;
import javax.validation.Valid;
import com.cs348.crud.entities.Student;
import com.cs348.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cs348.crud.repositories.StudentRepository;

import java.util.*;
@Controller
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/add-student")
    public String showSignUpForm(Student student) {
        return "add-student";
    }
    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "add-student";
        }
        long startTime = new Date().getTime();
        try {
            studentRepository.save(student);
        } catch ( Exception ex ) {
            result.rejectValue("email", "error.email", "Email address already exists for this name.");
            model.addAttribute("student", student);
            return "add-student";
        }
        long endTime = new Date().getTime();
        System.out.println("Time to add a student in JDBC Template = " + (endTime - startTime));
        model.addAttribute("students", studentRepository.findAll());
        return "studentIndex";
    }
    @GetMapping("/studentEdit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "update-student";
    }
    @PostMapping("/studentUpdate/{id}")
    public String updateStudent(@PathVariable("id") Integer id, @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
        //    student.setId(new ObjectId(id));
            return "update-student";
        }
        long startTime = new Date().getTime();
        try {
            studentRepository.update(student);
        } catch ( Exception ex ) {
            result.rejectValue("email", "error.email", "Email address already exists for this name.");
            model.addAttribute("student", student);
            return "update-student";
        }

    long endTime = new Date().getTime();
        System.out.println("Time to update student in JDBC Template = " + (endTime - startTime));
        model.addAttribute("students", studentRepository.findAll());
        return "studentIndex";
    }
    @GetMapping("/studentDelete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
        long startTime = new Date().getTime();
        studentRepository.deleteById(s.getId());
        long endTime = new Date().getTime();
        System.out.println("Time to delete a student in JDBC Template = " + (endTime - startTime));
        model.addAttribute("students", studentRepository.findAll());
        return "studentIndex";
    }
    @GetMapping("/studentIndex")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "studentIndex";
    }
}