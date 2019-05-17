package ru.platiza.service.test.client.ribbon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ExampleController {

    private final DiscoveryClient discoveryClient;


    private final LoadBalancerClient loadBalancer;

    private final RestTemplate restTemplate;

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
}
