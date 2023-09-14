package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.model.QuestionModel;
import com.quizApp.quizApplication.model.TopicModel;
import com.quizApp.quizApplication.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/editQuestion")
    public QuestionModel editEntity(@RequestBody @Valid QuestionModel questionModel) {

        return adminService.editQuestion(questionModel);
    }

    @PutMapping(value = "/editTopic")
    public TopicModel editTopic(@RequestBody @Valid TopicModel topicModel) {
        return adminService.editTopic(topicModel);
    }

    //    @PutMapping(value = "/topic/edit{id}")
//    public TopicModel editEntity(@RequestBody @Valid TopicModel topicmodel) {
//        TopicModel existingEntity = existingDao.findbyId(id)
//                .orElseThrow(()-> new ConfigDataResourceNotFoundException("entity is not found"));
//        existingEntity.setTopicId(questionModel.getTopicId());
//        existingEntity.setDescription(questionModel.getTopicdescription());
//        TopicModel savedEntity = existingDao.save(existingEntity);
//        return adminService.editEntity(topicmodel);
//    }
//
    @DeleteMapping("/deleteTopic/{id}")
    public String deleteEntity(@PathVariable Integer id) {
        adminService.deleteTopic(id);
        return "Topic " + id + " deleted successfully";
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        adminService.deleteQuestion(id);
        return "Question " + id + " deleted successfully";
    }
//
//    @DeleteMapping("/question/delete/{id}")
//    public QuestionModel<?>  deleteEntity(@PathVariable Long id){
//        QuestionModel.deleteById(id);
//        return QuestionModel.ok().build();
//    }

}
