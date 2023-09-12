package com.quizApp.quizApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.dao.QuestionDAO;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	
	public List<Question> getAllQuestions(){
		return questionDao.findAll();
	}
	
	public String getUserInput(String response) {
		List<Question> question = questionDao.findByQuestionDescription(response);
		if(question == null) {
			//Question Not Found
			return "Error: Please check the input";
		}
		else {
			// Question Found
			//Step-1: check whether the answer is correct or not
			String correctAnswers = CheckAnswer(question,1);
			
			//step-2: calculate the score
//			int calculatedScore = scoreCalculation(result);
			
			//return new String("correct Answer: "+ correctAnswers + " And the calculated score is: "+calculatedScore);
			return new String("correct Answer: "+ correctAnswers);
		}
		
	}
	
	public String checkAllAnswers(String[] correctAnswers){
		List<Question> questions = questionDao.findAll();
		StringBuilder results = new StringBuilder();
		results.append("The correct Answers are: ");
		//int score = 0;
		for(int i=0; i<questions.size(); i++)
		{
			if(questions.get(i).getCorrectAnswer().equalsIgnoreCase(correctAnswers[i])) {
				results.append(questions.get(i).getCorrectAnswer());
				//score = score + 1;
			}
		}
		//results.append("And the calculated Score is: "+ score);
		return results.toString();
	}

	public String getUserInputById(int questionId) {
		List<Question> result = questionDao.findByQuestionId(questionId);
		if(result == null) {
			//Question Not Found
			return "Error: Please check the input";
		}
		else {
			// Question Found
			//Step-1: check whether the answer is correct or not
			String correctAnswers = CheckAnswer(result,0);
			
			//step-2: calculate the score
//			int calculatedScore = scoreCalculation(result);
			
			//return new String("correct Answer: "+ correctAnswers + " And the calculated score is: "+calculatedScore);
			return new String("correct Answer: "+ correctAnswers);
		}
	}
	
	public String CheckAnswer(List<Question> result, int flag) {
		
		if(flag == 1) {
		StringBuilder results = new StringBuilder();
		for(int i=0; i<result.size(); i++) {
			String answer = result.get(i).getQuestionDescription();
			results.append(result.get(i).getQuestionDescription());
			if(answer.equals(result.get(i).getOption1())){
				results.append(result.get(i).getOption1());
			}
			else if(answer.equals(result.get(i).getOption2())){
				results.append(result.get(i).getOption2());
			}
			else if(answer.equals(result.get(i).getOption3())){
				results.append(result.get(i).getOption3());
			}
			else if (answer.equals(result.get(i).getOption4())){
				results.append(result.get(i).getOption4());
			}
			else {
				results.append("Something went wrong");
			}
		}
		return results.toString();
		}
		else if(flag == 0) {

			StringBuilder results = new StringBuilder();
			results.append("The correct Option is: ");
			for(int i=0; i<result.size(); i++) {
				String answer = result.get(i).getQuestionDescription();
				results.append(result.get(i).getQuestionDescription());
				results.append(" And the Correct Option Description is: ");
				if(answer.equals("option1")){
					results.append(result.get(i).getOption1());
				}
				else if(answer.equals("option2")){
					results.append(result.get(i).getOption2());
				}
				else if(answer.equals("option3")){
					results.append(result.get(i).getOption3());
				}
				else if (answer.equals("option4")){
					results.append(result.get(i).getOption4());
				}
				else {
					results.append("Something went wrong");
				}
			}
			return results.toString();
		}
		else
			return "Internal Error : 500";
	}
	
//	public int scoreCalculation(List<Question> result) {
//		int score = 0;
//		for(int i=0; i<result.size(); i++)
//			score = score+1;
//		return score;
//	}
}
