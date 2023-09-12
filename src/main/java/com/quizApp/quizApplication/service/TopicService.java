package com.quizApp.quizApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.dao.TopicDAO;

@Service
public class TopicService {

	@Autowired
	TopicDAO topicDao;
	
	public List<Topic> getAllTopics() {
		return topicDao.findAll();
	}

//	public List<Topic> getTopicByName(String topicName) {
//		return topicDao.getTopicByName(topicName);
//	}

	
}
