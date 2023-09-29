package com.quizApp.quizApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

import com.quizApp.quizApplication.entity.Question;
import com.quizApp.quizApplication.dao.QuestionDAO;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	
	
	public QuestionService(QuestionDAO questionDao) {
		// TODO Auto-generated constructor stub
		this.questionDao = questionDao;
	}


	/*******************************************************
	 * This method is for getting all the questions
	 * @return
	 *******************************************************/
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
	}
	
	
	/**********************************************************************************
	 * This method is to get  according to the option selected by the user
	 * Here the selected option's full value is given instead of the question_Id
	 * @param response
	 * @return
	 *********************************************************************************/
	public ResponseEntity<String> getUserInput(String response) {
		List<Question> question = questionDao.findByQuestionDescription(response);
		if(question == null) {
			//Question Not Found
			return new ResponseEntity<>("Error: Please check the input",HttpStatus.BAD_REQUEST);
		}
		else {
			String correctAnswers = CheckAnswer(question,1);
//			int calculatedScore = scoreCalculation(result);			
//			return new String("correct Answer: "+ correctAnswers + " And the calculated score is: "+calculatedScore);
			return new ResponseEntity<>(new String("correct Answer: "+ correctAnswers),HttpStatus.OK);
		}
		
	}
	
	/**********************************************************************************************************
	 * This method id used to check all the correct answers when all answers are provided in one go
	 * @param correctAnswers
	 * @return
	 **********************************************************************************************************/
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

	/**************************************************************************************************
	 * This method is used to get correct answer one by one when the front-end gives questionId
	 * @param questionId
	 * @return
	 ***************************************************************************************************/
	public ResponseEntity<String> getUserInputById(int questionId) {
		List<Question> result = questionDao.findByQuestionId(questionId);
		if(result == null) {
			//Question Not Found
			return new ResponseEntity<>("Error: Please check the input",HttpStatus.BAD_REQUEST);
		}
		else {
			// Question Found
			//Step-1: check whether the answer is correct or not
			String correctAnswers = CheckAnswer(result,0);
			
			//step-2: calculate the score
//			int calculatedScore = scoreCalculation(result);
			
			//return new String("correct Answer: "+ correctAnswers + " And the calculated score is: "+calculatedScore);
			return new ResponseEntity<>(new String("correct Answer: "+ correctAnswers),HttpStatus.OK);
		}
	}
	
	/****************************************************************************
	 * This method is used to check the answer provided by the user
	 * This is a helper method for checking of answers
	 * @param result
	 * @param flag
	 * @return
	 ****************************************************************************/
	public String CheckAnswer(List<Question> result, int flag) {
		
		if(flag == 1) {
		StringBuilder results = new StringBuilder();
		for(int i=0; i<result.size(); i++) {
			String answer = result.get(i).getCorrectAnswer();
			results.append(result.get(i).getCorrectAnswer());
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
				String answer = result.get(i).getCorrectAnswer();
				results.append(result.get(i).getCorrectAnswer());
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


	public ResponseEntity<List<Question>> getQuestionsByTopic(Integer topicId) {
		return new ResponseEntity<>(questionDao.findQuestionsByTopicId(topicId),HttpStatus.OK);
	}
	
}
