package com.quizApp.quizApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("getUserInputs/{response}")
	public String getUserInput(@PathVariable String response){
		return questionService.getUserInput(response);
	}
	
	@GetMapping("getUserInputId/{questionId}")
	public String getUserInputId(@PathVariable int questionId){
		return questionService.getUserInputById(questionId);
	}
	
	@GetMapping("checkAllAnswers")
	public String checkAllAnswers() {
		String[] correctAnswers = {"D","D"};
		return questionService.checkAllAnswers(correctAnswers);
	}
}
