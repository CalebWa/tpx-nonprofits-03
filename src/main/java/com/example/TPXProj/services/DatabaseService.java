package com.example.TPXProj.services;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.repositories.DatabaseNonprofitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DatabaseService {
    @Autowired
    private DatabaseNonprofitRepository repository;

    @GetMapping("/api/nonprofits")
    public Iterable<DatabaseNonprofit> apiFindAllNonProfits() {
        return repository.findAll();
    }

    @GetMapping("/api/nonprofits/formatted")
    public String printNonprofits() {
        ArrayList<Nonprofit> nonprofitArrayList = NonprofitParser.parseDatabase(repository.findAll());
        String output = "";
        for (Nonprofit nonprofit : nonprofitArrayList) {
            output += nonprofit.printNonprofit();
            output += "<br><br>";
        }

        return output;
    }


    public Iterable<DatabaseNonprofit> findAllNonprofits() {
        return repository.findAll();
    }
}
