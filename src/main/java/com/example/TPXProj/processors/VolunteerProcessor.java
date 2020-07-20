package com.example.TPXProj.processors;

import com.example.TPXProj.models.DatabaseNonprofit;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.models.Volunteer;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.parsers.VolunteerParser;
import com.example.TPXProj.services.DatabaseService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class VolunteerProcessor {
    private Volunteer volunteer;
    private String formString;

    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public VolunteerProcessor(String formString) {
        this.formString = formString;
        this.volunteer = new Volunteer(VolunteerParser.parseString(formString));
    }

    public String output() {
        DatabaseService dbs = new DatabaseService();
        PriorityQueue<Nonprofit> nonprofitRanks = this.rankNonprofits(NonprofitParser.parseDatabase(dbs.findAllNonprofits()));

        //Compare against the one volunteer
        //Create hashmap/rank data sheet

        System.out.println(this.formString);
        System.out.println(this.volunteer);
        return  "Your best nonprofit is: <br>" +
                nonprofitRanks.remove().printNonprofit();
    }

    private PriorityQueue<Nonprofit> rankNonprofits(ArrayList<Nonprofit> databaseNonprofits) {
        PriorityQueue<Nonprofit> nonprofitRanks = new PriorityQueue<>(new Comparator<Nonprofit>() {
            @Override
            public int compare(Nonprofit o1, Nonprofit o2) {
                return - Integer.compare(o1.getScore(), o2.getScore());
            }
        });

        for (Nonprofit curNonprofit : databaseNonprofits) {
            int curScore = 0;

            if (curNonprofit.getLocation().equals(volunteer.getLocation())) {
                curScore += 720;
            }

            for (Integer need : curNonprofit.getNeeds()) {
                if (need.equals(volunteer.getContribution())) {
                    curScore += 360;
                }
            }

            for (Integer commitment : curNonprofit.getCommitments()) {
                if (commitment.equals(volunteer.getAvailability())) {
                    curScore += 180;
                }
            }

            for (Integer curNonprofitActivity : curNonprofit.getActivities()) {
                for (Integer volunteerActivity : volunteer.getActivities()) {
                    if (curNonprofitActivity.equals(volunteerActivity)) {
                        curScore += 12;
                    }
                }
            }

            for (Integer curNonprofitSkill : curNonprofit.getSkills()) {
                for (Integer volunteerSkill : volunteer.getSkills()) {
                    if (curNonprofitSkill.equals(volunteerSkill)) {
                        curScore++;
                    }
                }
            }

            curNonprofit.setScore(curScore);

            nonprofitRanks.add(curNonprofit);
        }

        return nonprofitRanks;
    }
}
