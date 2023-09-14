package com.quizApp.quizApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@Entity
@ToString
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;
    private String topicName;
    private String description;
    @OneToMany(mappedBy = "topic")
    @JsonManagedReference
    private Set<Question> questions;

}
