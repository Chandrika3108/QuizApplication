package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PutMapping(value = "/addTopic")
    public TopicModel addTopic(@RequestBody @Valid TopicModel topicModel) {

        return adminService.addTopic(topicModel);
    }

    @PutMapping(value = "/addQuestion")
    public QuestionModel addQuestion(@RequestBody @Valid QuestionModel questionModel) {

        return adminService.addQuestion(questionModel);
    }


}
