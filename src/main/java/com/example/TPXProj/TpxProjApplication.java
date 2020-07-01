package com.example.TPXProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    String hello() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                    "<head>\n" +
                        "<title>tpx-nonprofits-03</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                        "\n" +
                        "<h1>tpx-nonprofits-03</h1>\n" +
                        "<p>Hello World!</p>\n" +
                        "\n" +
                    "</body>\n" +
                "</html>";
    }
}
