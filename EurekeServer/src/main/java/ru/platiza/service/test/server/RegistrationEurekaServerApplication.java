package ru.platiza.service.test.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistrationEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationEurekaServerApplication.class, args);
    }
}
