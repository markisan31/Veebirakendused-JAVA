package com.bezkoder.springjwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("noauth")
@Slf4j
public class PlantControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void insertAndUpdateAndGetAndDelete() {
        InputStream is = this.getClass().getResourceAsStream("/requests/plant.json");
        String body = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        long uuid = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<String>(body, headers);

        String json = restTemplate.postForObject("/plants", request, String.class);
        log.info("MachineResourceTest problem");
        log.info(json);
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"Sunflower\",\"category\":\"Homeplant\",\"wateringCycle\":1}");

        // Update year field
        body = body.replace("Sunflower", "NotSunFlower");
        HttpEntity<String> updateEntity = new HttpEntity<String>(body, headers);
        HttpEntity<String> response = restTemplate.exchange("/plants/" + uuid, HttpMethod.PUT, updateEntity, String.class);

        json = response.getBody();
        assertThat(json).isEqualTo("{\"id\":1,\"name\":\"NotSunFlower\",\"category\":\"Homeplant\",\"wateringCycle\":1}");        HttpEntity<String> getEntity = new HttpEntity<String>(headers);
        response = restTemplate.exchange("/plants/" + uuid, HttpMethod.GET, getEntity, String.class);
        assertThat(response.getBody()).isNotNull();

        HttpEntity<String> deleteEntity = new HttpEntity<String>(headers);
        response = restTemplate.exchange("/plants/" + uuid, HttpMethod.DELETE, deleteEntity, String.class);
        assertThat(response.getBody()).isNull();
    }
}
