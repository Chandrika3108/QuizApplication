//package com.quizApp.quizApplication;
//
//import com.quizApp.quizApplication.controller.AdminController;
//import com.quizApp.quizApplication.model.QuestionModel;
//import com.quizApp.quizApplication.model.TopicModel;
//import com.quizApp.quizApplication.service.AdminService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.mockito.Mockito.*;
//
//public class AdminControllerTest {
//
//    @InjectMocks
//    private AdminController adminController;
//
//    @Mock
//    private AdminService adminService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddTopic() {
//    
//        TopicModel topicModel = new TopicModel();
//        topicModel.setTopicName("Test Topic");
//        topicModel.setDescription("Description");
//
//       
//        when(adminService.addTopic(any(TopicModel.class))).thenReturn(topicModel);
//        ResponseEntity<TopicModel> responseEntity = adminController.addTopic(topicModel);
//        verify(adminService, times(1)).addTopic(any(TopicModel.class));
//        
//        assert responseEntity.getStatusCode() == HttpStatus.OK;
//        assert responseEntity.getBody() != null;
//        assert responseEntity.getBody().getTopicName().equals("Test Topic");
//        assert responseEntity.getBody().getDescription().equals("Description");
//    }
//
//    @Test
//    public void testAddQuestion() {
//        
//        QuestionModel questionModel = new QuestionModel();
//        questionModel.setTopicId(1);
//        questionModel.setQuestionDescription("Test Question");
//        questionModel.setOption1("Option 1");
//        questionModel.setOption2("Option 2");
//        questionModel.setOption3("Option 3");
//        questionModel.setOption4("Option 4");
//        questionModel.setCorrectAnswer("Option 1");
//
//     
//        when(adminService.addQuestion(any(QuestionModel.class))).thenReturn(questionModel);
//
//        ResponseEntity<QuestionModel> responseEntity = adminController.addQuestion(questionModel);
//
//        verify(adminService, times(1)).addQuestion(any(QuestionModel.class));
//
//        assert responseEntity.getStatusCode() == HttpStatus.OK;
//        assert responseEntity.getBody() != null;
//        assert responseEntity.getBody().getQuestionDescription().equals("Test Question");
//        assert responseEntity.getBody().getOption1().equals("Option 1");
//        assert responseEntity.getBody().getOption2().equals("Option 2");
//        assert responseEntity.getBody().getOption3().equals("Option 3");
//        assert responseEntity.getBody().getOption4().equals("Option 4");
//        assert responseEntity.getBody().getCorrectAnswer().equals("Option 1");
//    }
//}
