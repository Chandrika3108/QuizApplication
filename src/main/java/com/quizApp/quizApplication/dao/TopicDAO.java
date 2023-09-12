package com.quizApp.quizApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.quizApplication.entity.Topic;

@Repository
public interface TopicDAO extends JpaRepository<Topic, Integer>{
	
	//List<Topic> getTopicByName(String topicName);
}
