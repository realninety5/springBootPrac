package com.eplat.web.controller;


import com.eplat.web.model.Question;
import com.eplat.web.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class ServiceSurveyTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
    public void getDetailsForQuestion() throws Exception {
        Question mockQuestions = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        Mockito.when(
                surveyService.retrieveQuestion(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(mockQuestions);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/surveys/Survey1/questions/Question1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void createQuestion() throws Exception {
        Question mockQuestion = new Question("1", "Smallest Number", "1",
                Arrays.asList("1", "2", "3", "4"));

        String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
        Mockito.when(surveyService.addQuestion(Mockito.anyString(), Mockito.any(Question.class)))
                .thenReturn(mockQuestion);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/survey/Survey1/questions")
                .accept(MediaType.APPLICATION_JSON).content(questionJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}
