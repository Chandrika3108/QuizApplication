package com.quizApp.quizApplication.service;

import com.quizApp.quizApplication.dao.QuestionDAO;
import com.quizApp.quizApplication.entity.Question;
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
public class QuestionServiceTests {
    @InjectMocks
    QuestionService questionService;

    @Mock
    QuestionDAO questionDao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void getAllQuestionsTests() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findAll()).thenReturn(List.of(question));
        ResponseEntity<List<Question>> response = questionService.getAllQuestions();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(1, response.getBody().size());
    }


    @Test
    public void getUserInputTestSuccess() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findByQuestionDescription("Which language has compilation of code")).thenReturn(List.of(question));
        ResponseEntity<String> response = questionService.getUserInput(question.getQuestionDescription());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getUserInputTestFailure() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findByQuestionDescription("Which language has compilation of code")).thenReturn(null);
        ResponseEntity<String> response = questionService.getUserInput(question.getQuestionDescription());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void checkAllAnswersTests() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findAll())
                .thenReturn(List.of(question));
        String response = questionService.checkAllAnswers(new String[]{"option1"});

        Assert.assertEquals("The correct Answers are: option1", response);
    }

    @Test
    public void getUserInputByIdTestSuccess() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findByQuestionId(1)).thenReturn(List.of(question));
        ResponseEntity<String> response = questionService.getUserInputById(question.getQuestionId());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getUserInputByIdTestFailure() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findByQuestionId(1)).thenReturn(null);
        ResponseEntity<String> response = questionService.getUserInputById(question.getQuestionId());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void CheckAnswerTestsFlagAsOne() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("Java");
        Question question1 = new Question();
        question1.setQuestionId(2);
        question1.setQuestionDescription("Which language has compilation of code");
        question1.setOption1("Python");
        question1.setOption2("Java");
        question1.setOption3("Javascript");
        question1.setOption4("Html");
        question1.setCorrectAnswer("Java");
        Question question2 = new Question();
        question2.setQuestionId(3);
        question2.setQuestionDescription("Which language has compilation of code");
        question2.setOption1("Javascript");
        question2.setOption2("Python");
        question2.setOption3("Java");
        question2.setOption4("Html");
        question2.setCorrectAnswer("Java");
        Question question3 = new Question();
        question3.setQuestionId(4);
        question3.setQuestionDescription("Which language has compilation of code");
        question3.setOption1("Html");
        question3.setOption2("Python");
        question3.setOption3("Javascript");
        question3.setOption4("Java");
        question3.setCorrectAnswer("Java");
        Question question4 = new Question();
        question4.setQuestionId(5);
        question4.setQuestionDescription("Which language has compilation of code");
        question4.setOption1("Java");
        question4.setOption2("Python");
        question4.setOption3("Javascript");
        question4.setOption4("Html");
        question4.setCorrectAnswer("wrong option");
        String answers = questionService.CheckAnswer(List.of(question, question1, question2, question3, question4), 1);
        Assert.assertEquals("JavaJavaJavaJavaJavaJavaJavaJavawrong optionSomething went wrong", answers);
    }

    @Test
    public void CheckAnswerTestsFlagAsZero() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Question question1 = new Question();
        question1.setQuestionId(2);
        question1.setQuestionDescription("Which language has compilation of code");
        question1.setOption1("Python");
        question1.setOption2("Java");
        question1.setOption3("Javascript");
        question1.setOption4("Html");
        question1.setCorrectAnswer("option2");
        Question question2 = new Question();
        question2.setQuestionId(3);
        question2.setQuestionDescription("Which language has compilation of code");
        question2.setOption1("Javascript");
        question2.setOption2("Python");
        question2.setOption3("Java");
        question2.setOption4("Html");
        question2.setCorrectAnswer("option3");
        Question question3 = new Question();
        question3.setQuestionId(4);
        question3.setQuestionDescription("Which language has compilation of code");
        question3.setOption1("Html");
        question3.setOption2("Python");
        question3.setOption3("Javascript");
        question3.setOption4("Java");
        question3.setCorrectAnswer("option4");
        Question question4 = new Question();
        question4.setQuestionId(5);
        question4.setQuestionDescription("Which language has compilation of code");
        question4.setOption1("Java");
        question4.setOption2("Python");
        question4.setOption3("Javascript");
        question4.setOption4("Html");
        question4.setCorrectAnswer("wrong option");
        String answers = questionService.CheckAnswer(List.of(question, question1, question2, question3, question4), 0);
        Assert.assertEquals("The correct Option is: option1 And the Correct Option Description is: Javaoption2 And the Correct Option Description is: Javaoption3 And the Correct Option Description is: Javaoption4 And the Correct Option Description is: Javawrong option And the Correct Option Description is: Something went wrong", answers);
    }


    @Test
    public void CheckAnswerTestsWrongFlag() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Question question1 = new Question();
        question1.setQuestionId(2);
        question1.setQuestionDescription("Which language has compilation of code");
        question1.setOption1("Python");
        question1.setOption2("Java");
        question1.setOption3("Javascript");
        question1.setOption4("Html");
        question1.setCorrectAnswer("option2");
        Question question2 = new Question();
        question2.setQuestionId(3);
        question2.setQuestionDescription("Which language has compilation of code");
        question2.setOption1("Javascript");
        question2.setOption2("Python");
        question2.setOption3("Java");
        question2.setOption4("Html");
        question2.setCorrectAnswer("option3");
        Question question3 = new Question();
        question3.setQuestionId(4);
        question3.setQuestionDescription("Which language has compilation of code");
        question3.setOption1("Html");
        question3.setOption2("Python");
        question3.setOption3("Javascript");
        question3.setOption4("Java");
        question3.setCorrectAnswer("option4");
        Question question4 = new Question();
        question4.setQuestionId(5);
        question4.setQuestionDescription("Which language has compilation of code");
        question4.setOption1("Java");
        question4.setOption2("Python");
        question4.setOption3("Javascript");
        question4.setOption4("Html");
        question4.setCorrectAnswer("wrong option");
        String answers = questionService.CheckAnswer(List.of(question, question1, question2, question3, question4), 2);
        Assert.assertEquals("Internal Error : 500", answers);
    }


    @Test
    public void getQuestionsByTopicTests() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("Which language has compilation of code");
        question.setOption1("Java");
        question.setOption2("Python");
        question.setOption3("Javascript");
        question.setOption4("Html");
        question.setCorrectAnswer("option1");
        Mockito.when(questionDao.findQuestionsByTopicId(2)).thenReturn(List.of(question));
        ResponseEntity<List<Question>> response = questionService.getQuestionsByTopic(2);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(1, response.getBody().size());
    }


}
