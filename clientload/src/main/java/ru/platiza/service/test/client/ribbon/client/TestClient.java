package ru.platiza.service.test.client.ribbon.client;


import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.platiza.service.test.client.ribbon.data.TestDto;
import ru.platiza.service.test.client.ribbon.data.TestResponse;

import java.util.List;

@FeignClient(name = "externalClient",url = "${application.client.url}")
public interface TestClient {

    @GetMapping("/test/")
    List<TestResponse> getTestListWithoutParam();

    @GetMapping("/test/{param}")
    List<TestResponse> getTestListWithPathVariable(@PathVariable("param") String param);

    @GetMapping("/test/param/?param1={param}")
    List<TestResponse> getTestListWithParam(@Param("param") String param);

    @PostMapping("/test/post")
    void testingPost(TestDto dto);
}
