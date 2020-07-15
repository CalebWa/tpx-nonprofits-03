package com.example.TPXProj.models;

import java.util.ArrayList;

public class Nonprofit {
    private String name;
    private String website;
    private String phone;
    private String email;
    private ArrayList<Integer> need;
    private ArrayList<Integer> activities;
    private ArrayList<Integer> skills;
    private ArrayList<Integer> commitments;
    private Integer location;
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Integer> getNeed() {
        return need;
    }

    public void setNeed(ArrayList<Integer> need) {
        this.need = need;
    }

    public void addNeed(Integer need) {
        this.need.add(need);
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

    public ArrayList<Integer> getCommitments() {
        return commitments;
    }

    public void setCommitments(ArrayList<Integer> commitments) {
        this.commitments = commitments;
    }

    public void addCommitment(Integer commitment) {
        this.commitments.add(commitment);
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
