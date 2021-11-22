package com.eplat.web.controller;

import com.eplat.web.model.Question;
import com.eplat.web.model.Survey;
import com.eplat.web.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/survey/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @PostMapping("/survey/{surveyId}/questions")
    public ResponseEntity<Question> addQuestions(@PathVariable String surveyId, @RequestBody Question newQuestion) {
        Question question = surveyService.addQuestion(surveyId, newQuestion);

        if (question==null) return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(question.getId()).toUri();
        return ResponseEntity.created(location).body(question);
    }

    @GetMapping("survey/{surveyId}/{questionId}")
    public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }

    @GetMapping("/surveys")
    public List<Survey> retrieveSurveys() {
        return surveyService.retrieveAllSurveys();
    }
}
