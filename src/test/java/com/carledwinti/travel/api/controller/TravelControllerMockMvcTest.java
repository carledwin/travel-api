package com.carledwinti.travel.api.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.carledwinti.travel.api.constants.Constants.*;

/**
 * It NOT starts the server for ALL,
 * but to test only below that,
 * starts the application context,
 * starts the application,
 * Inject the Controller,
 * Listen for a connection
 * Send an HTTP request and assert the response
 * Provide a random port
 * ./mvnw test
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMessageStatus() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_REQUEST_TRAVEL_STATUS))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo(MESSAGE_SUCCESSFULLY)));
    }
}
