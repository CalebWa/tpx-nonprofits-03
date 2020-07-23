package com.example.TPXProj.parsers;

import com.example.TPXProj.models.Volunteer;

/**
 * Volunteer parser handles Volunteer processing from html form String to Volunteer object
 *
 * @author Caleb Warner
 */
public class VolunteerParser {
    // *************************************************************************
    // Constants
    // *************************************************************************
    /** Constant field to reference the name in a split html form component. */
    private static final Integer componentName = 0;

    /** Constant field to reference the value in a split html form component. */
    private static final Integer componentValue = 1;


    // *************************************************************************
    // Public Methods
    // *************************************************************************
    /**
     * Takes a string given by an html form request and splits based on the "&" and "=" syntax used.
     * Assigns values to a new Volunteer object.
     *
     * @param parseString String generated by an html form post request
     * @return New Volunteer object created from info found in parseString
     */
    public static Volunteer parseString(String parseString) {
        // Split up String based on html form "&" syntax into components
        String[] parseArray = parseString.split("&");

        // Create empty Nonprofit to be filled
        Volunteer volunteer = new Volunteer();

        // Iterate through components and add info to volunteer
        for (String formData : parseArray) {
            // Split up components based on the "=" syntax dividing field name and value
            String[] components = formData.split("=");
            switch(components[componentName]) {
                case "contribution":
                    // Set contribution accordingly
                    volunteer.setContribution(Integer.parseInt(components[componentValue]));
                    break;
                case "activity":
                    // Set activity accordingly
                    volunteer.addActivity(Integer.parseInt(components[componentValue]));
                    break;
                case "skill":
                    // Set skill accordingly
                    volunteer.addSkill(Integer.parseInt(components[componentValue]));
                    break;
                case "availability":
                    // Set availability accordingly
                    volunteer.setAvailability(Integer.parseInt(components[componentValue]));
                    break;
                case "location":
                    // Set location accordingly
                    volunteer.setLocation(Integer.parseInt(components[componentValue]));
                    break;
                default:
                    // Should not ever occur, print error message and disregard
                    System.out.println("This shouldn't exist, lol");
                    break;
            } // switch
        } // for each

        // Return filled in nonprofit
        return volunteer;
    } // public static Volunteer parseString()
} // public class VolunteerParser
