package com.cubex.survey.v1.services;

import com.cubex.survey.v1.models.Choice;

public interface IChoiceService {

    public Choice createChoice(Choice choice);

    public void deleteChoice(int id);

    public Choice updateChoice(Choice choice);

    public Choice getChoiceById(int id);


}
