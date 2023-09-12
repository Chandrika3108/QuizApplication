package com.quizApp.quizApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.quizApplication.entity.Topic;
import com.quizApp.quizApplication.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@GetMapping("getAllTopics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
//	@GetMapping("getTopicByName")
//	public List<Topic> getTopicByName(@PathVariable String topicName) {
//		return topicService.getTopicByName(topicName);
//	}
	
}
