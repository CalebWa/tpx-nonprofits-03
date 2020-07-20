package com.example.TPXProj.parsers;

import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.models.DatabaseNonprofit;

import java.util.ArrayList;

public class NonprofitParser {
    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public static Nonprofit parseString(String parseString) {
        String[] parseArray = parseString.split("&");
        Nonprofit nonprofit = new Nonprofit();
        for (String formData : parseArray) {
            String[] components = formData.split("=");
            switch(components[componentName]) {
                case "name":
                    nonprofit.setName(components[componentValue]);
                    break;
                case "website":
                    nonprofit.setWebsite(components[componentValue]);
                    break;
                case "phone":
                    nonprofit.setPhone(components[componentValue]);
                    break;
                case "email":
                    nonprofit.setEmail(components[componentValue]);
                    break;
                case "need":
                    nonprofit.addNeed(Integer.parseInt(components[componentValue]));
                    break;
                case "activity":
                    nonprofit.addActivity(Integer.parseInt(components[componentValue]));
                    break;
                case "skill":
                    nonprofit.addSkill(Integer.parseInt(components[componentValue]));
                    break;
                case "commitment":
                    nonprofit.addCommitment(Integer.parseInt(components[componentValue]));
                    break;
                case "location":
                    nonprofit.setLocation(Integer.parseInt(components[componentValue]));
                    break;
                default:
                    System.out.println("This shouldn't exist, lol");
                    break;
            }
        }

        return nonprofit;
    }

    public static ArrayList<Nonprofit> parseDatabase(Iterable<DatabaseNonprofit> nonprofits) {
        ArrayList<Nonprofit> nonprofitArrayList = new ArrayList<>();
        for (DatabaseNonprofit nonprofit : nonprofits) {
            Nonprofit curNonprofit = new Nonprofit();
            curNonprofit.setName(nonprofit.getName());
            curNonprofit.setWebsite(nonprofit.getWebsite());
            curNonprofit.setPhone(nonprofit.getPhone());
            curNonprofit.setEmail(nonprofit.getEmail());

            int needs = nonprofit.getNeeds();
            for (int i = 0; needs > 0; i++) {
                if (needs % 10 != 0) {
                    curNonprofit.addNeed(i);
                }
                needs /= 10;
            }

            long activities = nonprofit.getActivities();
            for (int i = 0; activities > 0; i++) {
                if (activities % 10 != 0) {
                    curNonprofit.addActivity(i);
                }
                activities /= 10;
            }

            long skills = nonprofit.getSkills();
            for (int i = 0; skills > 0; i++) {
                if (skills % 10 != 0) {
                    curNonprofit.addSkill(i);
                }
                skills /= 10;
            }

            int commitments = nonprofit.getCommitments();
            for (int i = 0; commitments > 0; i++) {
                if (commitments % 10 != 0) {
                    curNonprofit.addCommitment(i);
                }
                commitments /= 10;
            }

            curNonprofit.setLocation(nonprofit.getLocation());

            nonprofitArrayList.add(curNonprofit);
        }

        return nonprofitArrayList;
    }
}
