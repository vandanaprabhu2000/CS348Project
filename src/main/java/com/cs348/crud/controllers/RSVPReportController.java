package com.cs348.crud.controllers;
import com.cs348.crud.entities.Club;
import com.cs348.crud.entities.RSVPReport;
import com.cs348.crud.entities.RSVPSearchForm;
import com.cs348.crud.entities.Student;
import com.cs348.crud.repositories.RSVPReportRepository;
import com.cs348.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cs348.crud.repositories.StudentRepository;

import javax.validation.Valid;
import java.util.*;
@Controller
public class RSVPReportController {
    @Autowired
    private final RSVPReportRepository rsvpReportRepository;
    @Autowired
    public RSVPReportController(RSVPReportRepository rsvpReportRepository){
        this.rsvpReportRepository = rsvpReportRepository;
    }
    @GetMapping("/searchReport")
    public String showSearchForm(RSVPSearchForm rsvpSearchForm, Model model) {
        model.addAttribute("rsvpSearchForm", rsvpSearchForm);

        return "rsvpSearch";
    }
    @GetMapping("/rsvpReport")
    public String generateReport(Model model){
        List<RSVPReport> rsvpReportList = rsvpReportRepository.generateReport();
        model.addAttribute("rsvpReports", rsvpReportList);
        return "rsvpReport";

    }

    @PostMapping("/searchReport")
    public String SearchReport(@Valid RSVPSearchForm rsvpSearchForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rsvpSearchForm", rsvpSearchForm);
            return "rsvpSearch";
        }

        List<RSVPReport> rsvpReports = rsvpReportRepository.generateReport(rsvpSearchForm);
        if( rsvpReports.isEmpty()) {
            rsvpReports = null;
        }
        model.addAttribute("rsvpReports", rsvpReports);
        return "rsvpReport";
    }
}
