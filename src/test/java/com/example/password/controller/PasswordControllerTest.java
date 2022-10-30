package com.example.password.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/{productId}", 1);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName", equalTo("蘋果（澳洲）")))
                .andExpect(jsonPath("$.category", equalTo("FOOD")))
                .andExpect(jsonPath("$.imageUrl", notNullValue()))
                .andExpect(jsonPath("$.price", notNullValue()))
                .andExpect(jsonPath("$.stock", notNullValue()))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

    @Test
    public void getProduct_notFound() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/{productId}", 20000);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }


    @Transactional
    @Test
    public void deleteProduct_deleteExistingProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}", 5);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(204));
    }

    @Transactional
    @Test
    public void deleteProduct_deleteNonExistingProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}", 20000);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(204));
    }

    @Test
    public void getProducts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(5)));
    }

    @Test
    public void getProducts_filtering() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("search", "B")
                .param("category", "CAR");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(2)));
    }

    @Test
    public void getProducts_sorting() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("orderBy", "price")
                .param("sort", "desc");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(5)))
                .andExpect(jsonPath("$.results[0].productId", equalTo(6)))
                .andExpect(jsonPath("$.results[1].productId", equalTo(5)))
                .andExpect(jsonPath("$.results[2].productId", equalTo(7)))
                .andExpect(jsonPath("$.results[3].productId", equalTo(4)))
                .andExpect(jsonPath("$.results[4].productId", equalTo(2)));
    }

    @Test
    public void getProducts_pagination() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("limit", "2")
                .param("offset", "2");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(2)))
                .andExpect(jsonPath("$.results[0].productId", equalTo(5)))
                .andExpect(jsonPath("$.results[1].productId", equalTo(4)));
    }
}
