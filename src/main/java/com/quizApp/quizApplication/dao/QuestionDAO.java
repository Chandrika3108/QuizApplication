package com.quizApp.quizApplication.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.quizApplication.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByQuestionDescription(String correctAnswer);
	List<Question> findByQuestionId(int questionId);
}
