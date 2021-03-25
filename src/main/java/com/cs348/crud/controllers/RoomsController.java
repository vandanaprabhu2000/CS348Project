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
public class RoomsController {
    @Autowired
    private final RoomsRepository roomsRepository;
    @Autowired
    private RoomsService roomsService;
    @Autowired
    public RoomsController(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }
    @GetMapping("/add-rooms")
    public String showSignUpForm(Rooms rooms) {
        return "add-rooms";
    }
    @PostMapping("/addrooms")
    public String addRoom(@Valid Student rooms, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", rooms);
            return "add-rooms";
        }
        long startTime = new Date().getTime();
        try {
            roomsRepository.save(rooms);
        } catch ( Exception ex ) {
            result.rejectValue("email", "error.email", "Email address already exists for this name.");
            model.addAttribute("rooms", rooms);
            return "add-rooms";
        }
        long endTime = new Date().getTime();
        System.out.println("Time to add a rooms in JDBC Template = " + (endTime - startTime));
        model.addAttribute("rooms", roomsRepository.findAll());
        return "roomsIndex";
    }
    @GetMapping("/roomsEdit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Rooms rooms = roomsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rooms Id:" + id));
        model.addAttribute("rooms", rooms);
        return "update-rooms";
    }
    @PostMapping("/roomsUpdate/{id}")
    public String updateRoom(@PathVariable("id") Integer id, @Valid Rooms rooms, BindingResult result, Model model) {
        if (result.hasErrors()) {
        //    student.setId(new ObjectId(id));
            return "update-rooms";
        }
        long startTime = new Date().getTime();
        try {
            roomsRepository.update(rooms);
        } catch ( Exception ex ) {
            result.rejectValue("id", "id.number", "Room id already exists for this name.");
            model.addAttribute("rooms", rooms);
            return "update-rooms";
        }

    long endTime = new Date().getTime();
        System.out.println("Time to update rooms in JDBC Template = " + (endTime - startTime));
        model.addAttribute("rooms", roomsRepository.findAll());
        return "roomsIndex";
    }
    @GetMapping("/roomsDelete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id, Model model) {
        Rooms s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
        long startTime = new Date().getTime();
        roomsRepository.deleteById(s.getId());
        long endTime = new Date().getTime();
        System.out.println("Time to delete a rooms in JDBC Template = " + (endTime - startTime));
        model.addAttribute("rooms", roomsRepository.findAll());
        return "roomsIndex";
    }
    @GetMapping("/roomsIndex")
    public String listRoom(Model model) {
        List<Rooms> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "roomsIndex";
    }
}