package com.tts.capstone.SmartShreveCity2.service;

import com.tts.capstone.SmartShreveCity2.model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
    User saveNewUser(User user);
    User getLoggedInUser();

}   // end of the User Service interface