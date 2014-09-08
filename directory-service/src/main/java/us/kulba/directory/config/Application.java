package us.kulba.directory.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"us.kulba.directory"})
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}