package com.quizApp.quizApplication.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@NotNull
@Data
public class QuestionModel {
	
	  	Integer questionId;
	  	
	  	public Integer getQuestionId() {
			return questionId;
		}
		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}
		public Integer getTopicId() {
			return topicId;
		}
		public void setTopicId(Integer topicId) {
			this.topicId = topicId;
		}
		public String getQuestionDescription() {
			return questionDescription;
		}
		public void setQuestionDescription(String questionDescription) {
			this.questionDescription = questionDescription;
		}
		public String getOption1() {
			return option1;
		}
		public void setOption1(String option1) {
			this.option1 = option1;
		}
		public String getOption2() {
			return option2;
		}
		public void setOption2(String option2) {
			this.option2 = option2;
		}
		public String getOption3() {
			return option3;
		}
		public void setOption3(String option3) {
			this.option3 = option3;
		}
		public String getOption4() {
			return option4;
		}
		public void setOption4(String option4) {
			this.option4 = option4;
		}
		public String getCorrectAnswer() {
			return correctAnswer;
		}
		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}
		Integer topicId;
	  	@NotBlank(message = "cannot be blank")
	    String questionDescription;
	  	@NotBlank(message = "cannot be blank")
	    String option1;
	  	@NotBlank(message = "cannot be blank")
	    String option2;
	  	@NotBlank(message = "cannot be blank")
	    String option3;
	  	@NotBlank(message = "cannot be blank")
	    String option4;
	  	@NotBlank(message = "cannot be blank")
	    String correctAnswer;
	  	



}
