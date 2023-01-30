package com.cubex.survey.v1.services.impl;

import com.cubex.survey.v1.models.User;
import com.cubex.survey.v1.services.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserBySurveyId(int surveyId) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
