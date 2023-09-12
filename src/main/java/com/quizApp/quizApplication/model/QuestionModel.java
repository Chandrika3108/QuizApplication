package com.quizApp.quizApplication.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@NotNull
@Data
public class QuestionModel {
	
	  	int questionId;
	  	
	  	int topicId;
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
