package com.example.TPXProj.inserters;

import com.example.TPXProj.mappers.OutputMapper;
import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.readers.FileReader;

import java.util.PriorityQueue;

public class NonprofitInserter {
    private static final String filePath = "src/main/webapp/volunteer-submit-test.html";
    private static final String namePlaceHolder = "[name?]";
    private static final String websitePlaceHolder = "[website?]";
    private static final String phonePlaceHolder = "[phone?]";
    private static final String emailPlaceHolder = "[email?]";
    private static final String needsPlaceHolder = "[needs?]";
    private static final String activitiesPlaceHolder = "[activities?]";
    private static final String skillsPlaceHolder = "[skills?]";
    private static final String commitmentsPlaceHolder = "[commitments?]";
    private static final String locationPlaceHolder = "[location?]";

    private static OutputMapper outputMapper;


    public static String run(PriorityQueue<Nonprofit> nonprofitRanks) {
        String fileString = FileReader.readFile(filePath);
        outputMapper = new OutputMapper();

        for (int i = 0; i < 1; i++) {
            Nonprofit curNonprofit = nonprofitRanks.remove();

            fileString = insertNonprofit(fileString, curNonprofit, i);
        }

        return fileString;
    }

    private static String insertNonprofit(String fileString, Nonprofit nonprofit, int iteration) {
        String namePlaceHolder = NonprofitInserter.namePlaceHolder.replace('?', (char) (iteration + '1'));
        String activitiesPlaceHolder = NonprofitInserter.activitiesPlaceHolder.replace('?', (char) (iteration + '1'));
        String locationPlaceHolder = NonprofitInserter.locationPlaceHolder.replace('?', (char) (iteration + '1'));

        fileString = insertComponent(fileString, nonprofit.getName(), namePlaceHolder);
        fileString = insertComponent(fileString, nonprofit.getWebsite(), websitePlaceHolder);
        fileString = insertComponent(fileString, nonprofit.getPhone(), phonePlaceHolder);
        fileString = insertComponent(fileString, nonprofit.getEmail(), emailPlaceHolder);
        fileString = insertComponent(fileString, outputMapper.mapNeeds(nonprofit.getNeeds()), needsPlaceHolder);
        fileString = insertComponent(fileString, outputMapper.mapActivities(nonprofit.getActivities()), activitiesPlaceHolder);
        fileString = insertComponent(fileString, outputMapper.mapSkills(nonprofit.getSkills()), skillsPlaceHolder);
        fileString = insertComponent(fileString, outputMapper.mapCommitments(nonprofit.getCommitments()), commitmentsPlaceHolder);
        fileString = insertComponent(fileString, outputMapper.mapLocation(nonprofit.getLocation()), locationPlaceHolder);

        return fileString;
    }

    private static String insertComponent(String fileString, String newValue, String placeHolder) {
        int index = fileString.indexOf(placeHolder);
        int length = placeHolder.length();

        if (index >= 0) {
            fileString = fileString.substring(0, index) + newValue + fileString.substring(index + length);
        }

        return fileString;
    }
}
