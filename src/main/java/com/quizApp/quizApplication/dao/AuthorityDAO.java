package com.quizApp.quizApplication.dao;

import com.quizApp.quizApplication.entity.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AuthorityDAO extends CrudRepository<Authority, Long> {
    public Set<Authority> findByName(String name);
}
