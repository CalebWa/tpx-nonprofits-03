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
class HelloController {

	@GetMapping("/")
	String indexPage() {
	    try {
            File indexPageFile = new File("src\\main\\java\\com\\example\\TPXProj\\index.html");
            Scanner scanner = new Scanner(indexPageFile);
            StringBuilder indexPage = new StringBuilder();

            while (scanner.hasNextLine()) {
                indexPage.append(scanner.nextLine());
            }

            return indexPage.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        }
        return "";
	}
}