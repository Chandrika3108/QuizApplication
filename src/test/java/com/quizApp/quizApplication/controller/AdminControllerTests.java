package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
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

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTests {
    @Mock
    AdminService adminService;

    @InjectMocks
    AdminController adminController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTopicTest() {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("animals");
        topicModel.setDescription("A Quiz on Animals");
        TopicModel result = new TopicModel();
        result.setTopicName(topicModel.getTopicName());
        result.setDescription(topicModel.getDescription());
        result.setTopicId(1);
        Mockito.when(adminService.addTopic(topicModel)).thenReturn(result);
        ResponseEntity<TopicModel> response = adminController.addTopic(topicModel);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody().getTopicId(), result.getTopicId());

    }
    @Test
    public void addQuestionTest() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("mhhs");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        QuestionModel result = new QuestionModel();
        result.setQuestionDescription(questionModel.getQuestionDescription());
        result.setOption1(questionModel.getOption1());
        result.setOption2(questionModel.getOption2());
        result.setOption3(questionModel.getOption3());
        result.setOption4(questionModel.getOption4());
        result.setQuestionId(1);
        Mockito.when(adminService.addQuestion(questionModel)).thenReturn(result);
        ResponseEntity<QuestionModel> response = adminController.addQuestion(questionModel);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody().getQuestionId(), result.getQuestionId());
    }

    @Test
    public void EditTopicTest() {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("animals");
        topicModel.setDescription("A Quiz on Animals");
        topicModel.setTopicId(2);
        TopicModel result = new TopicModel();
        result.setTopicName(topicModel.getTopicName());
        result.setDescription(topicModel.getDescription());
        result.setTopicId(1);
        Mockito.when(adminService.editTopic(topicModel)).thenReturn(result);
        ResponseEntity<TopicModel> response = adminController.editTopic(topicModel);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody().getTopicId(), result.getTopicId());

    }
    @Test
    public void EditQuestionTest() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("mhhs");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setQuestionId(1);
        QuestionModel result = new QuestionModel();
        result.setQuestionDescription(questionModel.getQuestionDescription());
        result.setOption1(questionModel.getOption1());
        result.setOption2(questionModel.getOption2());
        result.setOption3(questionModel.getOption3());
        result.setOption4(questionModel.getOption4());
        result.setQuestionId(1);
        Mockito.when(adminService.editQuestion(questionModel)).thenReturn(result);
        ResponseEntity<QuestionModel> response = adminController.editEntity(questionModel);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody().getQuestionId(), result.getQuestionId());

    }


    @Test
    public void deleteTopicTest() {
        int id = 1;
        Mockito.doNothing().when(adminService).deleteTopic(id);
        ResponseEntity<String> response = adminController.deleteEntity(id);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "Topic " + id + " deleted successfully");

    }

    @Test
    public void deleteQuestionTest() {
        int id = 1;
        Mockito.doNothing().when(adminService).deleteQuestion(id);
        ResponseEntity<String> response = adminController.deleteQuestion(id);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "Question " + id + " deleted successfully");

    }

}
