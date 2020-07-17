package com.example.TPXProj.parsers;

import com.example.TPXProj.models.Nonprofit;

public class NonprofitParser {
    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public static Nonprofit parseString(String parseString) {
        String[] parseArray = parseString.split("&");
        Nonprofit nonprofit = new Nonprofit();
        for (String formData : parseArray) {
            String[] components = formData.split("=");
            switch(components[componentName]) {
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
}
