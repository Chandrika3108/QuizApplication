package com.quizApp.quizApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.service.QuestionService;

import java.util.*;

@RestController
@RequestMapping("/questions")
public class Controller {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("getUserInputId/{questionId}")
	public ResponseEntity<String> getUserInputId(@PathVariable int questionId){
		return questionService.getUserInputById(questionId);
	}
	
	@GetMapping("getQuestionsByTopic/{topicId}")
	public ResponseEntity<List<Question>> getQuestion(@PathVariable Integer topicId){
		return questionService.getQuestionsByTopic(topicId);
	}
	
	@GetMapping("getUserInputs/{response}")
	public ResponseEntity<String> getUserInput(@PathVariable String response){
		return questionService.getUserInput(response);
	}
	
	@GetMapping("checkAllAnswers")
	public String checkAllAnswers() {
		String[] correctAnswers = {"D","D"};
		return questionService.checkAllAnswers(correctAnswers);
	}
}
