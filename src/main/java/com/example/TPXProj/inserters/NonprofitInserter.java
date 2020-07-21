package com.example.TPXProj.inserters;

import com.example.TPXProj.models.Nonprofit;
import com.example.TPXProj.readers.FileReader;

import java.util.PriorityQueue;

public class NonprofitInserter {
    private static final String filePath = "src/main/webapp/volunteer-submit.html";
    private static final String namePlaceHolder = "[namei]";
    private static final String activitiesPlaceHolder = "[activitiesi]";
    private static final String locationPlaceHolder = "[locationi]";


    public static String run(PriorityQueue<Nonprofit> nonprofitRanks) {
        String fileString = FileReader.readFile("src/main/webapp/volunteer-submit.html");

        for (int i = 0; i < 1; i++) {
            Nonprofit curNonprofit = nonprofitRanks.remove();

            fileString = insertNonprofit(fileString, curNonprofit, i);
        }

        return fileString;
    }

    private static String insertNonprofit(String fileString, Nonprofit nonprofit, int iteration) {
        String namePlaceHolder = NonprofitInserter.namePlaceHolder.replace('i', Character.toChars(iteration)[0]);
        String activitiesPlaceHolder = NonprofitInserter.activitiesPlaceHolder.replace('i', Character.toChars(iteration)[0]);
        String locationPlaceHolder = NonprofitInserter.locationPlaceHolder.replace('i', Character.toChars(iteration)[0]);

        fileString = insertComponent(fileString, nonprofit.getName(), namePlaceHolder);
        //map activities and location
        fileString = insertComponent(fileString, nonprofit.getActivities().toString(), activitiesPlaceHolder);
        fileString = insertComponent(fileString, nonprofit.getLocation().toString(), locationPlaceHolder);

        return fileString;
    }

    private static String insertComponent(String fileString, String newValue, String placeHolder) {
        int index = fileString.indexOf(placeHolder);
        int length = placeHolder.length();
        
        fileString = fileString.substring(0, index) + newValue + fileString.substring(index + length);

        return fileString;
    }
}
