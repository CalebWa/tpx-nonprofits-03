package com.example.TPXProj.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Volunteer {
    private Integer contribution;
    private ArrayList<Integer> activities;
    private ArrayList<Integer> skills;
    private Integer availability;
    private Integer location;

    public Volunteer() {
        this.contribution = null;
        this.activities = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.availability = null;
        this.location = null;
    }

    public Volunteer(Volunteer volunteer) {
        this.contribution = volunteer.contribution;
        this.activities = volunteer.activities;
        this.skills = volunteer.skills;
        this.availability = volunteer.availability;
        this.location = volunteer.location;
    }

    public Integer getContribution() {
        return contribution;
    }

    public void setContribution(Integer contribution) {
        this.contribution = contribution;
    }

    public ArrayList<Integer> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Integer> activities) {
        this.activities = activities;
    }

    public void addActivity(Integer activity) {
        this.activities.add(activity);
    }

    public ArrayList<Integer> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Integer> skills) {
        this.skills = skills;
    }

    public void addSkill(Integer skill) {
        this.skills.add(skill);
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String printVolunteer() {
        return  "Contribution: " + this.contribution + "<br>" +
                "Activities: " + Arrays.toString(activities.toArray()) + "<br>" +
                "Skills: " + Arrays.toString(skills.toArray()) + "<br>" +
                "Availability: " + this.availability + "<br>" +
                "Location: " + this.location;
    }
}
