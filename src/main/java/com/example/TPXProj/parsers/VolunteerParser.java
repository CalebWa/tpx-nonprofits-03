package com.example.TPXProj.parsers;

import com.example.TPXProj.models.Volunteer;

public class VolunteerParser {
    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public static Volunteer parseString(String parseString) {
        String[] parseArray = parseString.split("&");
        Volunteer volunteer = new Volunteer();
        for (String formData : parseArray) {
            String[] components = formData.split("=");
            switch(components[componentName]) {
                case "contribution":
                    volunteer.setContribution(Integer.parseInt(components[componentValue]));
                    break;
                case "activity":
                    volunteer.addActivity(Integer.parseInt(components[componentValue]));
                    break;
                case "skill":
                    volunteer.addSkill(Integer.parseInt(components[componentValue]));
                    break;
                case "availability":
                    volunteer.setAvailability(Integer.parseInt(components[componentValue]));
                    break;
                case "location":
                    volunteer.setLocation(Integer.parseInt(components[componentValue]));
                    break;
                default:
                    System.out.println("This shouldn't exist, lol");
                    break;
            }
        }

        return volunteer;
    }
}
