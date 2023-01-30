package com.cubex.survey.v1.services;

import com.cubex.survey.v1.models.User;

public interface IUserService{

public User createUser(User user);

public User updateUser(User user);

public User getUser(int id);

public void deleteUser(int id);

public User getUserByEmail(String email);

public User getUserBySurveyId(int surveyId);

public User getUserById(int id);

}
