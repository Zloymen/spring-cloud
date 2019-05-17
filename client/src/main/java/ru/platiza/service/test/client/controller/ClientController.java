package ru.platiza.service.test.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final DiscoveryClient client;

    @GetMapping("/")
    public Map<String,List<ServiceInstance>> getOtherClient(){
        List<String> services = client.getServices();

        Map <String,List<ServiceInstance>> result = new HashMap<>();

        services.forEach(item -> result.put( item, client.getInstances(item)));

        return result;
    }
}
