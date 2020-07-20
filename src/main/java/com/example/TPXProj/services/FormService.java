package com.example.TPXProj.services;


import com.example.TPXProj.processors.VolunteerProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormService {
    @PostMapping("/volunteer-submit.html")
    public String serviceVolunteer(@RequestBody String formString) {
        VolunteerProcessor vp = new VolunteerProcessor(formString);
        return vp.output();
    }

    @PostMapping("/nonprofit-confirmation")
    public String serviceNonprofit(@RequestBody String formString) {
        System.out.println(formString);
        return "This functionality is not yet working.";
    }



    //Add GetMappings for those as well
}
