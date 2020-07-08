package com.example.TPXProj;

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
