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

    @PostMapping("/volunteer/response")
    public String testMethod(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "Hi, this is a test.";
    }
}
