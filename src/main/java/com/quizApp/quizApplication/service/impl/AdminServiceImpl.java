package com.quizApp.quizApplication.service.impl;

import com.quizApp.quizApplication.dao.QuestionDAO;
import com.quizApp.quizApplication.dao.TopicDAO;
import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
    TopicDAO topicDAO;

    @Autowired
    QuestionDAO questionDAO;


    @Override
    public TopicModel addTopic(TopicModel topicModel) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(topicModel, topic);
        topic = topicDAO.save(topic);
        topicModel.setTopicId(topic.getTopicId());
        return topicModel;
    }

    @Override
    public QuestionModel addQuestion(QuestionModel questionModel) {

        Optional<Topic> topicOptional = topicDAO.findById(questionModel.getTopicId());
        if (topicOptional.isEmpty()) {
            throw new RuntimeException("Topic given is not present, Please add the topic first");
        }
        Question question = new Question();
        question.setTopic(topicOptional.get());
        BeanUtils.copyProperties(questionModel, question);
        question = questionDAO.save(question);
        questionModel.setQuestionId(question.getQuestionId());
        return questionModel;
    }

    @Override
    public QuestionModel editQuestion(QuestionModel questionModel) {
        Optional<Question> questionOptional = questionDAO.findById(questionModel.getQuestionId());
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("Question given is not present");
        }

        Question question = questionOptional.get();
        if (questionModel.getTopicId() != null && !Objects.equals(question.getTopic().getTopicId(), questionModel.getTopicId())) {
            Optional<Topic> topicOptional = topicDAO.findById(questionModel.getTopicId());
            if (topicOptional.isEmpty()) {
                throw new RuntimeException("Topic given is not present, Please add the topic first");
            }
            question.setTopic(topicOptional.get());
        }
        BeanUtils.copyProperties(questionModel, question);
        question = questionDAO.save(question);
        BeanUtils.copyProperties(question, questionModel);
        questionModel.setTopicId(question.getTopic().getTopicId());
        return questionModel;
    }

    @Override
    public TopicModel editTopic(TopicModel topicModel) {
        Optional<Topic> topicOptional = topicDAO.findById(topicModel.getTopicId());
        if (topicOptional.isEmpty()) {
            throw new RuntimeException("Topic given is not present");
        }
        Topic topic = topicOptional.get();
        BeanUtils.copyProperties(topicModel, topic);
        topic = topicDAO.save(topic);
        BeanUtils.copyProperties(topic, topicModel);
        return topicModel;
    }

    @Override
    public void deleteTopic(Integer id) {
        Optional<Topic> topicOptional = topicDAO.findById(id);
        if (topicOptional.isEmpty()) {
            throw new RuntimeException("Topic given is not present");
        }
        questionDAO.deleteAllById(topicOptional.get().getQuestions().stream().map(Question::getQuestionId).collect(Collectors.toList()));
        topicDAO.deleteById(id);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionDAO.deleteById(id);
    }
}
