package ru.platiza.service.test.client.ribbon.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.platiza.service.test.client.ribbon.data.TestResponse;

import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Slf4j
public class WireMockTest {

    private RestTemplate template = new RestTemplate();

    @Test
    @DisplayName("")
    public void restTesting(){

        UriComponentsBuilder builder = fromHttpUrl("http://localhost:6666/").path("test/");

        ResponseEntity<List<TestResponse>> responseEntity = template.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TestResponse>>(){});

        //ResponseEntity<TestResponse[]> responseEntity = template.getForEntity(builder.build().toUri(),TestResponse[].class);

  /*      ResponseEntity<String> responseEntity = template.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                String.class);*/

        log.info("{}", responseEntity.getBody());
    }

    @Test
    @DisplayName("")
    public void pathTesting(){

        UriComponentsBuilder builder = fromHttpUrl("http://localhost:6666/").path("test/1234/");

        ResponseEntity<List<TestResponse>> responseEntity = template.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TestResponse>>(){});

        //ResponseEntity<TestResponse[]> responseEntity = template.getForEntity(builder.build().toUri(),TestResponse[].class);

  /*      ResponseEntity<String> responseEntity = template.exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                entity,
                String.class);*/

        log.info("{}", responseEntity.getBody());
    }
}
