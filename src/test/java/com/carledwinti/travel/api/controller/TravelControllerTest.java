package com.carledwinti.travel.api.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static com.carledwinti.travel.api.constants.Constants.*;

/**
 * It starts the server for ALL,
 * starts the application context,
 * starts the application,
 * Inject the Controller,
 * Listen for a connection
 * Send an HTTP request and assert the response
 * Provide a random port
 * ./mvnw test
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TravelControllerTest {

    @Autowired
    private TravelController controller;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads(){
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    public void getMessageTravelApiIsRunning(){
        String urlRequest = URL_LOCAL + port + SLASH + MAPPING_CONTROLLER_TRAVEL + SLASH + ENDPOINT_STATUS;
        String request = this.testRestTemplate.getForObject(urlRequest, String.class);
        Assertions.assertThat(request).contains(MESSAGE_SUCCESSFULLY);
    }
}
