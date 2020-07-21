package com.example.TPXProj.processors;

import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.parsers.NonprofitParser;

public class NonprofitProcessor {
    private Nonprofit nonprofit;

    public NonprofitProcessor(String formString) {
        this.nonprofit = new Nonprofit(NonprofitParser.parseString(formString));
    }

    public void saveNonprofit() {

    }
}
