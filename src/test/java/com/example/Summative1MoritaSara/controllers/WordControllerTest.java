package com.example.Summative1MoritaSara.controllers;

import com.example.Summative1MoritaSara.controller.QuoteAPIController.QuoteController;
import com.example.Summative1MoritaSara.models.WordModel.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Definition word;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        //Autowired
    }

    @Test
    public void returnRandomWordTest() throws Exception{

        String outputJson = objectMapper.writeValueAsString(word);

        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
