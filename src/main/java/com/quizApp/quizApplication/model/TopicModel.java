package com.quizApp.quizApplication.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@NotNull
@Data
public class TopicModel {


    int topicId;
    @NotBlank(message = "cannot be blank")
    String topicName;
    String description;

}