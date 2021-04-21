package com.carledwinti.travel.api.controller;

import com.carledwinti.travel.api.constants.Constants;
import com.carledwinti.travel.api.dto.BookingDto;
import com.carledwinti.travel.api.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Arrays;
import java.util.List;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookingService bookingService;

    @Test
    public void shouldReturnAll() throws Exception {

        List<BookingDto> bookingDtoList = Arrays
                .asList(BookingDto.builder().destination("Ubatuba").build(),
                        BookingDto.builder().destination("Caraguatatuba").build(),
                        BookingDto.builder().destination("Sao Sebastiao").build());

        Mockito.when(bookingService.all()).thenReturn(bookingDtoList);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(Constants.URL_BOOKING_ALL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destination", Matchers.equalTo(bookingDtoList.get(0).getDestination())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].destination", Matchers.equalTo(bookingDtoList.get(1).getDestination())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].destination", Matchers.equalTo(bookingDtoList.get(2).getDestination())));
    }
}
