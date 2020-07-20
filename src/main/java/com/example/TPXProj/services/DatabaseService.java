package com.example.TPXProj.services;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.repositories.NonprofitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseService {
    @Autowired
    private NonprofitsRepository repository;

//    @GetMapping("/api/nonprofits")
//    public Iterable<DatabaseNonprofit> findAllNonProfits() {
//        return "hi";
//    }
}
