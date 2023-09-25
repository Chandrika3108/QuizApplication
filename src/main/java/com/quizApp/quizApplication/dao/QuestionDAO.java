package com.quizApp.quizApplication.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizApp.quizApplication.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByQuestionDescription(String correctAnswer);
	List<Question> findByQuestionId(int questionId);
	
	@Query("select q from Question q where q.topic.topicId = :topicId")
	List<Question> findQuestionsByTopicId(@Param("topicId") Integer topicId);
}
