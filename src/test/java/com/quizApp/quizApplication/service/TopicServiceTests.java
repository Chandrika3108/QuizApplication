package com.quizApp.quizApplication.service;

import com.quizApp.quizApplication.controller.AdminController;
import com.quizApp.quizApplication.dao.TopicDAO;
import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.model.TopicModel;
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
public class TopicServiceTests {
    @Mock
    TopicDAO topicDao;
    @InjectMocks
    TopicService topicService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTopicsTest() {
        Topic topic = new Topic();
        topic.setTopicName("animals");
        topic.setTopicId(1);
        Mockito.when(topicDao.findAll()).thenReturn(List.of(topic));

        List<Topic> response = topicService.getAllTopics();
        Assert.assertEquals(1, response.size());

    }
}
