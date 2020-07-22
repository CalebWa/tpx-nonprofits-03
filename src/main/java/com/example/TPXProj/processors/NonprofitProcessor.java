package com.example.TPXProj.processors;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.readers.FileReader;
import com.example.TPXProj.repositories.DatabaseNonprofitRepository;

public class NonprofitProcessor {
    private static final String filePath = "src/main/webapp/nonprofit-submit.html";
    private Nonprofit nonprofit;

    public NonprofitProcessor(String formString) {
        this.nonprofit = new Nonprofit(NonprofitParser.parseString(formString));
    }

    public void saveNonprofit(DatabaseNonprofitRepository repository) {
        DatabaseNonprofit databaseNonprofit = NonprofitParser.deparseNonprofit(nonprofit);

        if (databaseNonprofit.getName() == null) {
            System.out.println("Failed nonprofit error checking, aborting repository save.");
            return;
        }

        repository.save(databaseNonprofit);
    }

    public String output() {
        return FileReader.readFile(filePath);
    }
}
