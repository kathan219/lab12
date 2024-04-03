package com.example.lab11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void automateDoubleNumber() throws Exception {

        int numberToDouble = 5;
        String url = "http://localhost:" + port + "/double?number=" + numberToDouble;
        Integer response = restTemplate.getForObject(url,Integer.class);
        assertThat(response).isEqualTo(numberToDouble * 2);

    }




}
