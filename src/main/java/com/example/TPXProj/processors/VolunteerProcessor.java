package com.example.TPXProj.processors;

import com.example.TPXProj.models.Volunteer;

public class VolunteerProcessor {
    private Volunteer volunteer;
    private String formString;

    private static final Integer componentName = 0;
    private static final Integer componentValue = 1;

    public VolunteerProcessor(String formString) {
        this.formString = formString;
        String[] formArray = formString.split("&");
        this.volunteer = new Volunteer();
        for (String formData : formArray) {
            String[] components = formData.split("=");
            switch(components[componentName]) {
                case "contribution":
                    volunteer.setContribution(Integer.parseInt(components[componentValue]));
                    break;
                case "activity":
                    volunteer.addActiity(Integer.parseInt(components[componentValue]));
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
