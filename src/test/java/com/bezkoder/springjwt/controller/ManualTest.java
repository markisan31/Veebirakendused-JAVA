package com.bezkoder.springjwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("noauth")
@Slf4j
public class ManualTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserController userController;

    @Test
    void registerNewUser() {
        InputStream is = this.getClass().getResourceAsStream("/requests/user.json");
        String body = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        long uuid = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<String>(body, headers);

        String json = restTemplate.postForObject("/users/process_register", request, String.class);
        log.info("MachineResourceTest problem");
        log.info(json);
    }
}
