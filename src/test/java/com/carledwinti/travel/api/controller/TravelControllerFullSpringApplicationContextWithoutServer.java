package com.carledwinti.travel.api.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.carledwinti.travel.api.constants.Constants.*;

/**
 * It NOT starts the server,
 * starts full spring application context,
 * ./mvnw test
 */
/*
@WebMvcTest - Error - Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of
because we have others controllers too
 */
//Here with narrow the scope to load only the application context to this Controller
@WebMvcTest(TravelController.class)
public class TravelControllerFullSpringApplicationContextWithoutServer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMessageStatus() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_REQUEST_TRAVEL_STATUS))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo(MESSAGE_SUCCESSFULLY)));
    }
}
