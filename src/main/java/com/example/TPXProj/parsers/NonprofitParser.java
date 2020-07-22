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


            if (nonprofit.getNeeds() == null) {
                //Don't include bad nonprofit
                continue;
            }

            int needs = Integer.parseInt(nonprofit.getNeeds());
            for (int i = 0; needs > 0; i++) {
                if (needs % 10 != 0) {
                    curNonprofit.addNeed(i);
                }
                needs /= 10;
            }


            if (nonprofit.getActivities() == null) {
                //Don't include bad nonprofit
                continue;
            }

            long activities = Long.parseLong(nonprofit.getActivities());
            for (int i = 0; activities > 0; i++) {
                if (activities % 10 != 0) {
                    curNonprofit.addActivity(i);
                }
                activities /= 10;
            }


            if (nonprofit.getSkills() == null) {
                //Don't include bad nonprofit
                continue;
            }

            long skills = Long.parseLong(nonprofit.getSkills());
            for (int i = 0; skills > 0; i++) {
                if (skills % 10 != 0) {
                    curNonprofit.addSkill(i);
                }
                skills /= 10;
            }


            if (nonprofit.getCommitments() == null) {
                //Don't include bad nonprofit
                continue;
            }

            int commitments = Integer.parseInt(nonprofit.getCommitments());
            for (int i = 0; commitments > 0; i++) {
                if (commitments % 10 != 0) {
                    curNonprofit.addCommitment(i);
                }
                commitments /= 10;
            }

            curNonprofit.setLocation(nonprofit.getLocation());

            if (!errorChecknonprofit(curNonprofit)) {
                //Don't include bad nonprofit
                continue;
            }

            curNonprofit.setName(cleanString(curNonprofit.getName()));
            curNonprofit.setWebsite(cleanString(curNonprofit.getWebsite()));
            curNonprofit.setPhone(cleanString(curNonprofit.getPhone()));
            curNonprofit.setEmail(cleanString(curNonprofit.getEmail()));

            nonprofitArrayList.add(curNonprofit);
        }

        return nonprofitArrayList;
    }

    private static String cleanString(String input) {
        input = input.replace('+', ' ');

        String operateString = input;
        StringBuilder output = new StringBuilder();
        int index = 0;

        while ((index = operateString.indexOf("%")) >= 0) {
            try {
                String hex = operateString.substring(index + 1, index + 3);
                int character = Integer.parseInt(hex, 16);

                output.append(operateString, 0,index);
                output.append((char) character);
                operateString = operateString.substring(index + 3);
            } catch (NumberFormatException e) {
                output.append(operateString, 0, index + 1);
                operateString = operateString.substring(index + 1);
            }
        }

        output.append(operateString);

        return output.toString();
    }

    public static DatabaseNonprofit deparseNonprofit(Nonprofit nonprofit) {
        if (!errorChecknonprofit(nonprofit)) {
            return new DatabaseNonprofit();
        }

        DatabaseNonprofit databaseNonprofit = new DatabaseNonprofit();

        databaseNonprofit.setName(nonprofit.getName());
        databaseNonprofit.setWebsite(nonprofit.getWebsite());
        databaseNonprofit.setPhone(nonprofit.getPhone());
        databaseNonprofit.setEmail(nonprofit.getEmail());

        int needs = 0;
        for (Integer need : nonprofit.getNeeds()) {
            int activeBit = 1;

            for (int i = 0; i < need; i++) {
                activeBit *= 10;
            }

            needs += activeBit;
        }
        databaseNonprofit.setNeeds(Integer.toString(needs));

        long activities = 0;
        for (Integer activity : nonprofit.getActivities()) {
            long activeBit = 1;

            for (int i = 0; i < activity; i++) {
                activeBit *= 10;
            }

            activities += activeBit;
        }
        databaseNonprofit.setActivities(Long.toString(activities));

        long skills = 0;
        for (Integer skill : nonprofit.getSkills()) {
            long activeBit = 1;

            for (int i = 0; i < skill; i++) {
                activeBit *= 10;
            }

            skills += activeBit;
        }
        databaseNonprofit.setSkills(Long.toString(skills));

        int commitments = 0;
        for (Integer commitment : nonprofit.getCommitments()) {
            int activeBit = 1;

            for (int i = 0; i < commitment; i++) {
                activeBit *= 10;
            }

            commitments += activeBit;
        }
        databaseNonprofit.setCommitments(Integer.toString(commitments));

        databaseNonprofit.setLocation(nonprofit.getLocation());

        return databaseNonprofit;
    }

    private static boolean errorChecknonprofit(Nonprofit nonprofit) {
        if (nonprofit.getName() == null || nonprofit.getName().equals("")) {
            return false;
        }

        if (nonprofit.getWebsite() == null || nonprofit.getWebsite().equals("")) {
            return false;
        }

        if (nonprofit.getPhone() == null || nonprofit.getPhone().equals("")) {
            return false;
        }

        if (nonprofit.getEmail() == null || nonprofit.getEmail().equals("")) {
            return false;
        }

        if (nonprofit.getNeeds().size() == 0) {
            return false;
        }

        if (nonprofit.getActivities().size() == 0) {
            return false;
        }

        if (nonprofit.getSkills().size() == 0) {
            return false;
        }

        if (nonprofit.getCommitments().size() == 0) {
            return false;
        }

        if (nonprofit.getLocation() < 0 || nonprofit.getLocation() > 8) {
            return false;
        }

        return true;
    }
}
