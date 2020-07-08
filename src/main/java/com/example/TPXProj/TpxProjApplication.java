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
            File indexPageFile = new File("index.html");
            Scanner scanner = new Scanner(indexPageFile);
            StringBuilder indexPage = new StringBuilder();

            while (scanner.hasNextLine()) {
                indexPage.append(scanner.nextLine());
            }

            return indexPage.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        }

		return "<html>\n" +
				"<head>\n" +
				"\t<title> Nonprofit Homepage</title>\n" +
				"\t<link rel=\"stylesheet\" href=\"style.css\">\n" +
				"</head>\n" +
				"<body>\n" +
				"\t<h1> This is where the header for the awareness page will be </h1>\n" +
				"\t\t<img src=\"child.png\" />\n" +
				"\t\t<p> Data invoking peoples pathos </p>\n" +
				"\t\t<img src=\"puppies.jpg\"/>\n" +
				"\t\t<p> Data invoking peoples ethos </p>\n" +
				"\t\t<img src=\"food.jpg\"/>\n" +
				"\t\t<p> Data invoking peoples logos \n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"\t<a href=\"Questionaire.html\">\n" +
				"\t<button type=\"button\" onclick=\"Volunteer()\"> Match Me With A Nonprofit! </button>\n" +
				"\t</a>\n" +
				"<br>\n" +
				"<br>\n" +
				"\t<a href=\"Questionaire2.html\">\n" +
				"\t<button type=\"button\" onclick=\"Nonprofit()\"> Register Your Nonprofit </button>\n" +
				"\t</a>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"<br>\n" +
				"\t<footer> Property of Nonprofit Team 3 </footer>\n" +
				"\t\n" +
				"</body>\n" +
				"</html>\n";
	}
}