package com.example.TPXProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class TpxProjApplication {
	public static void main(String[] args) {
		SpringApplication.run(TpxProjApplication.class, args);
	}
}

@RestController
class WebAppController {

	@GetMapping("/")
	String indexPage() {
	    try {
            File indexPageFile = new File("src/main/java/com/example/TPXProj/Index.html");
            Scanner scanner = new Scanner(indexPageFile);
            StringBuilder indexPage = new StringBuilder();

            while (scanner.hasNextLine()) {
                indexPage.append(scanner.nextLine());
            }

            return indexPage.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        }
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title> Nonprofit Homepage</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Techpoint Nonprofits 03!</h1>\n" +
                "    </body>\n" +
                "</html>";

	}
}