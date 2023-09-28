package com.quizApp.quizApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    AdminService adminService;
    
    @PostMapping (value = "/addTopic")
    public ResponseEntity<TopicModel> addTopic(@RequestBody @Valid TopicModel topicModel) {
        TopicModel result = adminService.addTopic(topicModel);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping(value = "/addQuestion")
    public ResponseEntity<QuestionModel> addQuestion(@RequestBody @Valid QuestionModel questionModel ) {
        QuestionModel result = adminService.addQuestion(questionModel);
        return ResponseEntity.ok(result);
    }

}

