package com.cs348.crud.controllers;

import javax.validation.Valid;
import com.cs348.crud.entities.Meetings;
import com.cs348.crud.repositories.MeetingsRepository;
import com.cs348.crud.service.MeetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
@Controller
public class MeetingsController {
    @Autowired
    private final MeetingsRepository meetingsRepository;
    @Autowired
    private MeetingsService meetingsService;
    @Autowired
    public MeetingsController(MeetingsRepository meetingsRepository) {
        this.meetingsRepository = meetingsRepository;
    }
    @GetMapping("/add-meetings")
    public String showSignUpForm(Meetings meetings) {
        return "add-meetings";
    }
    @PostMapping("/addmeetings")
    public String addMeeting(@Valid Meetings meetings, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("meetings", meetings);
            return "add-meetings";
        }
        long startTime = new Date().getTime();
        try {
            meetingsRepository.save(meetings);
        } catch ( Exception ex ) {
            result.rejectValue("email", "error.email", "Email address already exists for this name.");
            model.addAttribute("meetings", meetings);
            return "add-meetings";
        }
        long endTime = new Date().getTime();
        System.out.println("Time to add a meetings in JDBC Template = " + (endTime - startTime));
        model.addAttribute("meetings", meetingsRepository.findAll());
        return "meetingsIndex";
    }
    @GetMapping("/meetingsEdit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Meetings meetings = meetingsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid meetings Id:" + id));
        model.addAttribute("meetings", meetings);
        return "update-meetings";
    }
    @PostMapping("/meetingsUpdate/{id}")
    public String updateMeeting(@PathVariable("id") Integer id, @Valid Meetings meetings, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //    student.setId(new ObjectId(id));
            return "update-meetings";
        }
        long startTime = new Date().getTime();
        try {
            meetingsRepository.update(meetings);
        } catch ( Exception ex ) {
            result.rejectValue("id", "id.number", "Meeting id already exists for this name.");
            model.addAttribute("meetings", meetings);
            return "update-meetings";
        }

        long endTime = new Date().getTime();
        System.out.println("Time to update meetings in JDBC Template = " + (endTime - startTime));
        model.addAttribute("meetings", meetingsRepository.findAll());
        return "meetingsIndex";
    }
    @GetMapping("/meetingsDelete/{id}")
    public String deleteMeeting(@PathVariable("id") Integer id, Model model) {
        Meetings s = meetingsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
        long startTime = new Date().getTime();
        meetingsRepository.deleteById(s.getMeeting_id());
        long endTime = new Date().getTime();
        System.out.println("Time to delete a meeting in JDBC Template = " + (endTime - startTime));
        model.addAttribute("meetings", meetingsRepository.findAll());
        return "meetingsIndex";
    }
    @GetMapping("/meetingsIndex")
    public String listMeeting(Model model) {
        List<Meetings> meetings = meetingsRepository.findAll();
        model.addAttribute("meetings", meetings);
        return "meetingsIndex";
    }
}