package com.carledwinti.travel.api.controller;

import com.carledwinti.travel.api.service.TravelService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.carledwinti.travel.api.constants.Constants.MESSAGE_SUCCESSFULLY_FROM_SERVICE;
import static com.carledwinti.travel.api.constants.Constants.URL_REQUEST_TRAVEL_STATUS_FROM_SERVICE;

/**
 * It automatically injects the service dependency into controller(because of the constructor signeture,
 * but we can use the @Autowired without the constructor signature)
 * It creates the inject Mock to the service dependency(if you do not do so, the application context cannot start)
 * We set its expectation using Mockito to return the message
 */
@WebMvcTest(TravelWithServiceController.class)
public class TravelWithServiceControllerWebMvcMockServerWith {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TravelService travelService;

    @Test
    public void shouldReturnMessageStatusFromService() throws Exception {
        Mockito.when(travelService.status()).thenReturn(MESSAGE_SUCCESSFULLY_FROM_SERVICE);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_REQUEST_TRAVEL_STATUS_FROM_SERVICE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo(MESSAGE_SUCCESSFULLY_FROM_SERVICE)));
    }
}
