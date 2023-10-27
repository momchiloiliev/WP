package mk.ukim.finki.wp.lab1_nova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lab1NovaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1NovaApplication.class, args);
    }

}
