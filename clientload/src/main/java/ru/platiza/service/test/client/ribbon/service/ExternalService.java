package ru.platiza.service.test.client.ribbon.service;

import ru.platiza.service.test.client.ribbon.data.TestResponse;

import java.util.List;

public interface ExternalService {

    List<TestResponse> getData();
}
