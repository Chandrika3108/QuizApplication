package com.quizApp.quizApplication.service.impl;

import com.quizApp.quizApplication.dao.QuestionDAO;
import com.quizApp.quizApplication.dao.TopicDAO;
import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
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
}
