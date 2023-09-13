package com.munira.main.controller;

import com.munira.main.exceptions.PatientNotFoundException;
import com.munira.main.model.Patient;
import com.munira.main.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("patientList", patientService.getAllPatient());
        model.addAttribute("newPatient", new Patient()); // For the "Add Patient" form
        return "home-page.html";
    }

    @PostMapping("/find-by-id")
    public String findById(@RequestParam Integer id, Model model) {
        Patient patient = patientService.findById(id);
        if (patient == null) {
            throw new PatientNotFoundException("Patient with ID " + id + " is not found");
        }
        model.addAttribute("patient", patient);
        return "patient-page.html";
    }

    @GetMapping("/add-patient")
    public String addPatient() {
        return "add-patient-page.html";
    }

    @PostMapping("/save-patient")
    public String savePatient(@ModelAttribute Patient patient) {
        System.out.println("Adding patient: " + patient.getName());
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @PostMapping("/delete-patient")
    public String deletePatient(@RequestParam Integer id) {
        patientService.deletePatientById(id);
        return "redirect:/";
    }

    @PostMapping("/update-patient")
    public String updatePatient(@RequestParam Integer id, Model model) {
        model.addAttribute("patient", patientService.findById(id));
        return "update-patient.html";
    }

    @PostMapping("/save-updated-patient")
    public String saveUpdatedPatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/";
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public String handlePatientNotFoundException(PatientNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error-page.html";
    }
}
