package ru.platiza.service.test.client.ribbon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.platiza.service.test.client.ribbon.client.TestClient;
import ru.platiza.service.test.client.ribbon.data.TestResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalServiceImpl implements ExternalService {
    private final TestClient client;

    @Override
    public List<TestResponse> getData(){
        return client.getTestListWithoutParam();
    }
}
