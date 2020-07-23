package com.example.TPXProj.processors;

import com.example.TPXProj.inserters.NonprofitInserter;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.models.Volunteer;
import com.example.TPXProj.parsers.NonprofitParser;
import com.example.TPXProj.parsers.VolunteerParser;
import com.example.TPXProj.readers.FileReader;
import com.example.TPXProj.repositories.DatabaseNonprofitRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class VolunteerProcessor {
    private static final String filePath = "src/main/webapp/volunteer-submit.html";
    private static final String errorFilePath = "src/main/webapp/volunteer-submit-error.html";
    private static final String failureFilePath = "src/main/webapp/volunteer-submit-failure.html";

    private Volunteer volunteer;
    private PriorityQueue<Nonprofit> rankedNonprofits;

    public VolunteerProcessor() {
        this.volunteer = null;
    }

    public VolunteerProcessor(String formString) {
        this.volunteer = new Volunteer(VolunteerParser.parseString(formString));
    }

    public String output() {
        return NonprofitInserter.run(rankedNonprofits, filePath);
    }

    public void rankNonprofits(DatabaseNonprofitRepository repository) {
        PriorityQueue<Nonprofit> rankedNonprofits = new PriorityQueue<>(new Comparator<Nonprofit>() {
            @Override
            public int compare(Nonprofit o1, Nonprofit o2) {
                return - Integer.compare(o1.getScore(), o2.getScore());
            }
        });

        ArrayList<Nonprofit> databaseNonprofits = NonprofitParser.parseDatabase((repository.findAll()));

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

            rankedNonprofits.add(curNonprofit);
        }

        this.rankedNonprofits = rankedNonprofits;
    }

    public String error() {
        return FileReader.readFile(errorFilePath);
    }

    public String failure() {
        return FileReader.readFile(failureFilePath);
    }
}
