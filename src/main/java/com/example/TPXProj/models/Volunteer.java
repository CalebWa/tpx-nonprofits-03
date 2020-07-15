package com.example.TPXProj.models;

import java.util.ArrayList;

public class Volunteer {
    private Integer contribution;
    private ArrayList<Integer> activities;
    private ArrayList<Integer> skills;
    private Integer availability;
    private Integer location;

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

    public void addActiity(Integer activity) {
        activities.add(activity);
    }

    public ArrayList<Integer> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Integer> skills) {
        this.skills = skills;
    }

    public void addSkill(Integer skill) {
        skills.add(skill);
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
}
