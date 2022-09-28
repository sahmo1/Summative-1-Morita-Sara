package com.example.Summative1MoritaSara.controllers;

import com.example.Summative1MoritaSara.controller.Magic8BallController.AnswerController;
import com.example.Summative1MoritaSara.models.Magic8BallModel.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class Magic8BallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper used to convert Java object to JSON
    private ObjectMapper objectMapper = new ObjectMapper();
    @Before
    public void setUp(){};

    @Test
    public void returnAnswerTest() throws Exception {

        //testing for POSt request

        //create a new answer object
        Answer answer = new Answer();
        answer.setQuestion("Will I get a job at Netflix?");
        answer.setAnswer("Magic Ball says Absolutely!");

        //convert answer object to JSON
        String inputJson = objectMapper.writeValueAsString(answer);

        //perform POST request
        mockMvc.perform(
                        post("/magic")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

}
