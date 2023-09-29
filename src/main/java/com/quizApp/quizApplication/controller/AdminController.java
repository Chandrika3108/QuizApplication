package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/addTopic")
    public ResponseEntity<TopicModel> addTopic(@RequestBody @Valid TopicModel topicModel) {
        TopicModel result = adminService.addTopic(topicModel);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/addQuestion")
    public ResponseEntity<QuestionModel> addQuestion(@RequestBody @Valid QuestionModel questionModel) {
        QuestionModel result = adminService.addQuestion(questionModel);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/editTopic")
    public ResponseEntity<TopicModel> editTopic(@RequestBody @Valid TopicModel topicModel) {
        TopicModel result = adminService.editTopic(topicModel);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/editQuestion")
    public ResponseEntity<QuestionModel> editEntity(@RequestBody @Valid QuestionModel questionModel) {
        QuestionModel result = adminService.editQuestion(questionModel);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteTopic/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Integer id) {
        adminService.deleteTopic(id);
        return ResponseEntity.ok("Topic " + id + " deleted successfully");
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        adminService.deleteQuestion(id);
        return ResponseEntity.ok("Question " + id + " deleted successfully");
    }

}
