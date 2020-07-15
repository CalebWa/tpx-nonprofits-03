package com.example.TPXProj.services;

import com.example.TPXProj.models.Nonprofits;
import com.example.TPXProj.repositories.NonprofitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseService {
    @Autowired
    private NonprofitsRepository repository;

    @GetMapping("/api/nonprofits")
    public Iterable<Nonprofits> findAllNonProfits() {
        return repository.findAll();
    }

    @PostMapping("/volunteer-results")
    public String serviceVolunteer(@RequestBody String formString) {
        System.out.println(formString);
        return "This functionality is not yet working.";
    }

    @PostMapping("/nonprofit-confirmation")
    public String serviceNonprofit(@RequestBody String formString) {
        System.out.println(formString);
        return "This functionality is not yet working.";
    }
}
