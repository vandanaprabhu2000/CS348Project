package com.cs348.crud.controllers;

import com.cs348.crud.entities.Club;
import com.cs348.crud.repositories.ClubRepository;
import com.cs348.crud.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private final ClubRepository clubRepository;
    @Autowired
    private ClubService clubService;
    @Autowired
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @GetMapping("/add-club")
    public String showSignUpForm(Club club) {
        return "add-club";
    }
    @PostMapping("/addclub")
    public String addClub(@Valid Club club, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", club);
            return "add-club";
        }
        long startTime = new Date().getTime();
        try {
            clubRepository.save(club);
        } catch ( Exception ex )  {
            result.rejectValue("name", "error.name", "Club name already exists for this name.");
            model.addAttribute("club", club);
            return "add-club";
        }
        long endTime = new Date().getTime();
        System.out.println("Time to add a club in JDBC Template = " + (endTime - startTime));
        model.addAttribute("clubs", clubRepository.findAll());
        return "clubIndex";
    }
    @GetMapping("/clubEdit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid club Id:" + id));
        model.addAttribute("club", club);
        return "update-club";
    }
    @PostMapping("/clubUpdate/{id}")
    public String updateClub(@PathVariable("id") Integer id, @Valid Club club, BindingResult result, Model model) {
        if (result.hasErrors()) {
        //    student.setId(new ObjectId(id));
            return "update-club";
        }
        long startTime = new Date().getTime();
        try {
            clubRepository.update(club);
        } catch( Exception ex )  {
            result.rejectValue("name", "error.name", "Club name already exists for this name.");
            model.addAttribute("club", club);
            return "update-club";

        }
        long endTime = new Date().getTime();
        System.out.println("Time to update club in JDBC Template = " + (endTime - startTime));
        model.addAttribute("clubs", clubRepository.findAll());
        return "clubIndex";
    }
    @GetMapping("/clubDelete/{id}")
    public String deleteClub(@PathVariable("id") Integer id, Model model) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
        long startTime = new Date().getTime();
        clubRepository.deleteById(club.getId());
        long endTime = new Date().getTime();
        System.out.println("Time to delete a club in JDBC Template = " + (endTime - startTime));
        model.addAttribute("clubs", clubRepository.findAll());
        return "clubIndex";
    }
    @GetMapping("/clubIndex")
    public String listClubs(Model model) {
        List<Club> clubs = clubRepository.findAll();
        model.addAttribute("clubs", clubs);
        return "clubIndex";
    }
}