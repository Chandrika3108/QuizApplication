package com.quizApp.quizApplication.controller;


import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.service.TopicService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TopicControllerTests {
    @InjectMocks
    TopicController topicController;

    @Mock
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
        Mockito.when(topicService.getAllTopics()).thenReturn(List.of(topic));

        List<Topic> response = topicController.getAllTopics();
        Assert.assertEquals(1, response.size());

    }

}
