package com.example.TPXProj.processors;

import com.example.TPXProj.models.Volunteer;
import com.example.TPXProj.parsers.VolunteerParser;

public class VolunteerProcessor {
    private Volunteer volunteer;
    private String formString;

    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public VolunteerProcessor(String formString) {
        this.formString = formString;
        this.volunteer = VolunteerParser.parseString(formString);
    }

    public String output() {
        //Get all nonprofits
        //Parse all nonprofits
        //Compare against the one volunteer
        //Create hashmap/rank data sheet

        System.out.println(this.formString);
        System.out.println(this.volunteer);
        return "This functionality is not yet working.";
    }
}
