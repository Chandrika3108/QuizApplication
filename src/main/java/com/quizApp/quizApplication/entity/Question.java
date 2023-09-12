package com.quizApp.quizApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int questionId;
	@ManyToOne
	@JoinColumn(name="topic_id", nullable=false)
	@JsonBackReference
	Topic topic;
	String questionDescription;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctAnswer;
}
