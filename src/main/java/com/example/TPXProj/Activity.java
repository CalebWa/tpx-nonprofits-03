package com.example.TPXProj;
//Yeah I just want a hashmap for these
//Enums are for when it never changes while these might change
//I also need to easily switch between string and int which hashmap does
//Enums don't do what I need done
//Hashmap does

//I also need the ability to have many numbers of one field
//Have an array for each field?
//Score analyzer would iterate over array to see if any match

//Also need a string for nonprofit
public enum Activity {
    ADMINISTRATION(0),
    ADVOCACY(1),
    ARTS(2),
    CIVIC_ENGAGEMENT(3),
    CHILDREN_AND_YOUTH(4),
    EDUCATION(5),
    ELDERLY_AND_DISABLED(6),
    ENVIRONMENTAL(7),
    FOOD(8),
    FUNDRAISING(9),
    HEALTH(10),
    HOMELESS(11),
    HUMAN_SERVICE(12),
    RESEARCH(13);

    private final int value;
    Activity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
