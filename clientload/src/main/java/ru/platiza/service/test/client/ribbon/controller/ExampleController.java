package ru.platiza.service.test.client.ribbon.controller;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.platiza.service.test.client.ribbon.client.TestClient;
import ru.platiza.service.test.client.ribbon.data.TestResponse;
import ru.platiza.service.test.client.ribbon.service.ExternalService;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ExampleController {

    private final DiscoveryClient discoveryClient;


    private final LoadBalancerClient loadBalancer;

    private final RestTemplate restTemplate;

    private final ExternalService externalService;

    @GetMapping("/")
    public String runBalancer(){

        String serviceId = "XYZ-SERVICE".toLowerCase();

        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);

        ServiceInstance serviceInstance = this.loadBalancer.choose(serviceId);

        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(serviceInstance.getHost())
                .port(serviceInstance.getPort())
                .path("/hello")
                ;

        String result = restTemplate.getForObject(builder.build().toUri(), String.class);

        return result;
    }

    @GetMapping("/external/")
    public List<TestResponse> getListExternalService(){
        TestClient testClient = Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(TestClient.class, "http://localhost:6666");

        return testClient.getTestListWithoutParam();
        //return externalService.getData();
    }
}
