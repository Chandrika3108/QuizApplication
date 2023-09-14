package com.quizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    AdminService adminService;
    
    @PutMapping(value = "/addTopic")
    public ResponseEntity<TopicModel> addTopic(@RequestBody @Valid TopicModel topicModel) {
        TopicModel result = adminService.addTopic(topicModel);
        return ResponseEntity.ok(result);
    }
    
    @PutMapping(value = "/addQuestion")
    public ResponseEntity<QuestionModel> addQuestion(@RequestBody @Valid QuestionModel questionModel ) {
        QuestionModel result = adminService.addQuestion(questionModel);
        return ResponseEntity.ok(result);
    }

}

