package com.quizApp.quizApplication.service;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;

public interface AdminService {
    TopicModel addTopic(TopicModel topicModel);

    QuestionModel addQuestion(QuestionModel questionModel);

    QuestionModel editQuestion(QuestionModel questionModel);

    TopicModel editTopic(TopicModel topicModel);

    void deleteTopic(Integer id);

    void deleteQuestion(Integer id);
}
