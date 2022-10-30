package com.example.password.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void truePassword() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/passwordValid").content("1a2b3c");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200));
    }

    @Test
    public void noLowerLetterPassword() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/passwordValid").content("1234567");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }

    @Test
    public void noDigitPassword() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/passwordValid").content("abcdefg");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }

    @Test
    public void haveUpperLetterPassword() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/passwordValid").content("Bb1234");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }

    @Test
    public void haveRepeatPassword() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/passwordValid").content("1a1a");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }

}
