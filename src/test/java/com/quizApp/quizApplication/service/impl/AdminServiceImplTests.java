package com.quizApp.quizApplication.service.impl;

import com.quizApp.quizApplication.dao.QuestionDAO;
import com.quizApp.quizApplication.dao.TopicDAO;
import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTests {
    @InjectMocks
    AdminServiceImpl adminService;

    @Mock
    QuestionDAO questionDAO;

    @Mock
    TopicDAO topicDAO;

    @Test
    public void addTopicTest() {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("animals");
        topicModel.setDescription("A Quiz on Animals");
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicModel, topic);
        Topic result = new Topic();
        result.setTopicName(topicModel.getTopicName());
        result.setTopicId(1);
        Mockito.when(topicDAO.save(topic)).thenReturn(result);
        TopicModel response = adminService.addTopic(topicModel);
        Assert.assertEquals(response.getTopicId(), result.getTopicId());

    }

    @Test
    public void addQuestionTestSuccess() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("mhhs");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setTopicId(1);
        Question question = new Question();
        question.setQuestionDescription("What is programming?");
        question.setOption1("Machine Understandable lan");
        question.setOption2("mhhs");
        question.setOption3("hagah");
        question.setOption4("hagah");
        question.setTopicId(1);
        Topic topic = new Topic();
        topic.setTopicName("programming");
        topic.setTopicId(1);
        question.setTopic(topic);
        Question result = new Question();
        result.setQuestionDescription(question.getQuestionDescription());
        result.setOption1(question.getOption1());
        result.setOption2(question.getOption2());
        result.setOption3(question.getOption3());
        result.setOption4(question.getOption4());
        result.setQuestionId(1);
        result.setTopic(topic);
        Mockito.when(topicDAO.findById(questionModel.getTopicId())).thenReturn(Optional.of(topic));
        Mockito.when(questionDAO.save(question)).thenReturn(result);
        QuestionModel response = adminService.addQuestion(questionModel);
        Assert.assertEquals(response.getQuestionId(), result.getQuestionId());
    }

    @Test(expected = RuntimeException.class)
    public void addQuestionTestFailureWrongTopic() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("testing");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setTopicId(1);
        Mockito.when(topicDAO.findById(questionModel.getTopicId())).thenReturn(Optional.empty());
        adminService.addQuestion(questionModel);
    }

    @Test
    public void editQuestionTestSuccess() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("testing");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setTopicId(1);
        questionModel.setQuestionId(1);
        Topic topic = new Topic();
        topic.setTopicName("animals");
        topic.setTopicId(2);
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestionDescription("What is programming?");
        question.setOption1("Machine Understandable lan");
        question.setOption2("mhhs");
        question.setOption3("hagah");
        question.setOption4("hagah");
        question.setTopic(topic);
        Mockito.when(questionDAO.findById(questionModel.getQuestionId())).thenReturn(Optional.of(question));
        Mockito.when(topicDAO.findById(questionModel.getTopicId())).thenReturn(Optional.of(topic));
        question.setOption2(questionModel.getOption2());
        Mockito.when(questionDAO.save(question)).thenReturn(question);
        QuestionModel response = adminService.editQuestion(questionModel);
        Assert.assertEquals(questionModel.getQuestionId(), response.getQuestionId());

    }

    @Test(expected = RuntimeException.class)
    public void editQuestionTestFailureWrongQuestion() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("testing");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setTopicId(1);
        Mockito.when(questionDAO.findById(questionModel.getQuestionId())).thenReturn(Optional.empty());
        adminService.editQuestion(questionModel);
    }

    @Test(expected = RuntimeException.class)
    public void editQuestionTestFailureWrongTopic() {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setQuestionDescription("What is programming?");
        questionModel.setOption1("Machine Understandable lan");
        questionModel.setOption2("testing");
        questionModel.setOption3("hagah");
        questionModel.setOption4("hagah");
        questionModel.setTopicId(1);
        Topic topic = new Topic();
        topic.setTopicName("programming");
        topic.setTopicId(2);
        Question question = new Question();
        question.setQuestionDescription("What is programming?");
        question.setOption1("Machine Understandable lan");
        question.setOption2("mhhs");
        question.setOption3("hagah");
        question.setOption4("hagah");
        question.setTopic(topic);
        Mockito.when(questionDAO.findById(questionModel.getQuestionId())).thenReturn(Optional.of(question));
        Mockito.when(topicDAO.findById(questionModel.getTopicId())).thenReturn(Optional.empty());
        adminService.editQuestion(questionModel);
    }

    @Test
    public void editTopicTestSuccess() {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("animals");
        topicModel.setDescription("A Quiz on Animals");
        topicModel.setTopicId(1);
        Topic topic = new Topic();
        topic.setTopicName("programming");
        topic.setTopicId(1);
        Mockito.when(topicDAO.findById(topicModel.getTopicId())).thenReturn(Optional.of(topic));
        topic.setTopicName(topicModel.getTopicName());
        Mockito.when(topicDAO.save(topic)).thenReturn(topic);
        TopicModel response = adminService.editTopic(topicModel);
        Assert.assertEquals(topicModel.getTopicId(), response.getTopicId());
        Assert.assertEquals(topicModel.getTopicName(), response.getTopicName());
    }

    @Test(expected = RuntimeException.class)
    public void editTopicTestFailure() {
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("animals");
        topicModel.setDescription("A Quiz on Animals");
        topicModel.setTopicId(1);
        Optional<Topic> optionalTopic = Optional.empty();
        Mockito.when(topicDAO.findById(topicModel.getTopicId())).thenReturn(optionalTopic);
        adminService.editTopic(topicModel);
    }

    @Test
    public void deleteTopicTestSuccess() {
        Topic topic = new Topic();
        topic.setTopicName("programming");
        topic.setTopicId(1);
        Mockito.when(topicDAO.findById(topic.getTopicId())).thenReturn(Optional.of(topic));
        Mockito.doNothing().when(topicDAO).deleteById(topic.getTopicId());
        adminService.deleteTopic(topic.getTopicId());
        Mockito.verify(topicDAO).deleteById(topic.getTopicId());

    }

    @Test(expected = RuntimeException.class)
    public void deleteTopicTestFailure() {
        int id = 1;
        Optional<Topic> optionalTopic = Optional.empty();
        Mockito.when(topicDAO.findById(id)).thenReturn(optionalTopic);
        adminService.deleteTopic(id);

    }

    @Test
    public void deleteQuestionTestSuccess() {
        int id = 1;
        Mockito.doNothing().when(questionDAO).deleteById(id);
        adminService.deleteQuestion(id);
        Mockito.verify(questionDAO).deleteById(id);

    }

}
