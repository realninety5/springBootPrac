package com.eplat.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import com.eplat.web.WebApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerTest {

    String all_questions = "[\n" +
            "    {\n" +
            "        \"id\": \"Question1\",\n" +
            "        \"description\": \"Largest Country in the World\",\n" +
            "        \"correctAnswer\": \"Russia\",\n" +
            "        \"options\": [\n" +
            "            \"India\",\n" +
            "            \"Russia\",\n" +
            "            \"United States\",\n" +
            "            \"China\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"Question2\",\n" +
            "        \"description\": \"Most Populus Country in the World\",\n" +
            "        \"correctAnswer\": \"China\",\n" +
            "        \"options\": [\n" +
            "            \"India\",\n" +
            "            \"Russia\",\n" +
            "            \"United States\",\n" +
            "            \"China\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"Question3\",\n" +
            "        \"description\": \"Highest GDP in the World\",\n" +
            "        \"correctAnswer\": \"United States\",\n" +
            "        \"options\": [\n" +
            "            \"India\",\n" +
            "            \"Russia\",\n" +
            "            \"United States\",\n" +
            "            \"China\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"Question4\",\n" +
            "        \"description\": \"Second largest english speaking country\",\n" +
            "        \"correctAnswer\": \"India\",\n" +
            "        \"options\": [\n" +
            "            \"India\",\n" +
            "            \"Russia\",\n" +
            "            \"United States\",\n" +
            "            \"China\"\n" +
            "        ]\n" +
            "    }\n" +
            "]";

    @LocalServerPort
    private int port;

    @Test
    void retrieveQuestions() throws JSONException {
        // Define the url
        String url = "http://localhost:"+port+"/survey/Survey1/questions";
        // Define and set the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // Define and set the HttpEntity (body and headers)
        HttpEntity entity = new HttpEntity<String>(null, headers);
        // Define and set the TestRestTemplate to get the http request
        TestRestTemplate testTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        // Test your result
        JSONAssert.assertEquals(all_questions, response.getBody(), false);

    }

    @Test
    void addQuestions() {
        String expected = "{\n" +
                "    \"description\": \"Biggest Cunt in the World\",\n" +
                "    \"correctAnswer\": \"Buhari\",\n" +
                "    \"options\": [\n" +
                "        \"Buhari\",\n" +
                "        \"Tinubu\",\n" +
                "        \"Oyedipo\",\n" +
                "        \"Sanwo Olu\"\n" +
                "    ]\n" +
                "}";

        String url = "http://localhost:"+port+"/survey/Survey1/questions";
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(expected, header);
        TestRestTemplate template = new TestRestTemplate();
        ResponseEntity response = template.exchange(url, HttpMethod.POST, entity, String.class);
        //assertThat(response.getHeaders().get(HttpHeaders.LOCATION).get(0),
        //       containString(url));
        //assertTrue(response.getHeaders().get(HttpHeaders.)));
        //System.out.println(response.getBody().toString()+"\n\n\n\n\n"+expected);
        assertTrue(response.getBody().toString().contains(expected));
    }


    @Test
    public void testis() throws JSONException {
        JSONAssert.assertEquals("{ID:1}", "{ID:1, name:Oko}", false);

    }

    @Test
    void retrieveQuestion() throws JSONException {
        String url = "http://localhost:"+port+"/survey/Survey1/Question1";
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        //String output = testRestTemplate.getForObject(url, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        //System.out.println("------------------------Response = "+ response.getBody());


        //String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options:[India,Russia,United States,China]}";
        //String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options: [India,Russia,United States,China]}";
        //JSONAssert.assertEquals(expected, response.getBody(), false);
        String expected = "{\n" +
                "    \"id\": \"Question1\",\n" +
                "    \"description\": \"Largest Country in the World\",\n" +
                "    \"correctAnswer\": \"Russia\",\n" +
                "    \"options\": [\n" +
                "        \"India\",\n" +
                "        \"Russia\",\n" +
                "        \"United States\",\n" +
                "        \"China\"\n" +
                "    ]\n" +
                "}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    void retrieveSurveys() {
    }
}