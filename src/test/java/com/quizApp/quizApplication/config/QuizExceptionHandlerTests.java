package com.quizApp.quizApplication.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class QuizExceptionHandlerTests {
    @InjectMocks
    QuizExceptionHandler quizExceptionHandler;

    @Test
    public void handleAccessDeniedExceptionTests() {
        Exception ex = new RuntimeException("Invalid Date");
        ResponseEntity<Object> response = quizExceptionHandler.internalServerError(ex, null);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
