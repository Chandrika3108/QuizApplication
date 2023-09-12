package com.quizApp.quizApplication.service;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;

public interface AdminService {
  TopicModel addTopic(TopicModel topicModel);
  QuestionModel addQuestion(QuestionModel questionModel);
}
