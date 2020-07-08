package com.example.TPXProj;

public enum Location {
    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3),
    NORTHEAST(4),
    NORTHWEST(5),
    SOUTHEAST(6),
    SOUTHWEST(7);

    private final int value;
    Location(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
