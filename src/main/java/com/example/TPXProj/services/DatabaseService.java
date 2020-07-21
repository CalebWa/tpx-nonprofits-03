package com.example.TPXProj.services;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.processors.NonprofitProcessor;
import com.example.TPXProj.processors.VolunteerProcessor;
import com.example.TPXProj.readers.FileReader;
import com.example.TPXProj.repositories.DatabaseNonprofitRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/volunteer-submit.html")
    public String serviceVolunteer(@RequestBody String formString) {
        VolunteerProcessor vp = new VolunteerProcessor(formString);
        return vp.output(repository);
    }

    @PostMapping("/nonprofit-submit.html")
    public String serviceNonprofit(@RequestBody String formString) {
        NonprofitProcessor np = new NonprofitProcessor(formString);
        return FileReader.readFile("src/main/webapp/nonprofit-submit.html");
    }
}
