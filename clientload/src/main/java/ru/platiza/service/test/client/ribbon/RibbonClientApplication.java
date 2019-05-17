package ru.platiza.service.test.client.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.platiza.service.test.client.ribbon.configuration.RibbonConfiguration;

@SpringBootApplication
@RibbonClient(name = "ping-a-server", configuration = RibbonConfiguration.class)
public class RibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }

    @Bean
    public RestTemplate createRestTemplate(){

        return new RestTemplate();
    }
}
