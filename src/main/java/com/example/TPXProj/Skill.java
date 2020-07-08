package com.example.TPXProj;

public enum Skill {
    COMMUNICATION(0),
    INTERPERSONAL(1),
    CREATIVITY(2),
    LEADERSHIP(3),
    MENTORING(4),
    TRAINING(5),
    ORGANIZATION(6),
    PLANNING(7),
    PROBLEM_SOLVING(8),
    RELATIONSHIP_BUILDING(9),
    REPORTING(10),
    TEAMWORK(11),
    TIME_MANAGEMENT(12),
    TIMELINESS(13);

    private final int value;
    Skill(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
