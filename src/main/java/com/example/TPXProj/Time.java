package com.example.TPXProj;

public enum Time {
    SUNDAY_MORNING(0),
    SUNDAY_AFTERNOON(1),
    SUNDAY_EVENING(2),
    MONDAY_MORNING(3),
    MONDAY_AFTERNOON(4),
    MONDAY_EVENING(5),
    TUESDAY_MORNING(6),
    TUESDAY_AFTERNOON(7),
    TUESDAY_EVENING(8),
    WEDNESDAY_MORNING(9),
    WEDNESDAY_AFTERNOON(10),
    WEDNESDAY_EVENING(11),
    THURSDAY_MORNING(12),
    THURSDAY_AFTERNOON(13),
    THURSDAY_EVENING(14),
    FRIDAY_MORNING(15),
    FRIDAY_AFTERNOON(16),
    FRIDAY_EVENING(17),
    SATURDAY_MORNING(18),
    SATURDAY_AFTERNOON(19),
    SATURDAY_EVENING(20);

    private final int value;
    Time(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
