package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.service.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTests {
    @InjectMocks
    QuestionController questionController;

    @Mock
    QuestionService questionService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllQuestionsTest() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionService.getAllQuestions()).thenReturn(new ResponseEntity<>(List.of(question), HttpStatus.OK));
        ResponseEntity<List<Question>> response = questionController.getAllQuestions();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(1, response.getBody().size());
    }

    @Test
    public void getUserInputIdTests() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionService.getUserInputById(1)).thenReturn(new ResponseEntity<>("The correct Option is: option1 And the Correct Option Description is: Java", HttpStatus.OK));
        ResponseEntity<String> response = questionController.getUserInputId(1);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("The correct Option is: option1 And the Correct Option Description is: Java", response.getBody());
    }

    @Test
    public void getQuestionTest() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionService.getQuestionsByTopic(2)).thenReturn(new ResponseEntity<>(List.of(question), HttpStatus.OK));
        ResponseEntity<List<Question>> response = questionController.getQuestion(2);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(1, response.getBody().size());
    }

    @Test
    public void getUserInputTest() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionService.getUserInput("Which language has compilation of code")).thenReturn(new ResponseEntity<>("The correct Option is: option1 And the Correct Option Description is: Java", HttpStatus.OK));
        ResponseEntity<String> response = questionController.getUserInput(question.getQuestionDescription());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("The correct Option is: option1 And the Correct Option Description is: Java", response.getBody());
    }

    @Test
    public void checkAllAnswersTest() {

        Mockito.when(questionService.checkAllAnswers(new String[]{"D", "D"})).thenReturn("The correct Option is: option1 And the Correct Option Description is: Java");
        String response = questionController.checkAllAnswers();
        Assert.assertEquals("The correct Option is: option1 And the Correct Option Description is: Java", response);
    }
}
