package com.cubex.survey.v1.services.impl;

import com.cubex.survey.v1.models.User;
import com.cubex.survey.v1.repositories.IUserRepository;
import com.cubex.survey.v1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User getUserBySurveyId(int surveyId) {
        return this.userRepository.findUserBySurveyId(surveyId);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.findById(id).get();
    }
}
