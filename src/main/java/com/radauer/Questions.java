package com.radauer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 17.04.2017.
 */
public class Questions
{
    private List<Question> questions;

    public Questions()
    {
        this.questions = new ArrayList<>();

        Question question = new Question();
        question.setQuestion("How many digitisation experts are working for Porsche Informatik?");
        question.setAnswers(new String[]{"42", "450", "0111001"});
        question.setCorrectAnswer(1);
        questions.add(question);

        question.setQuestion("How many filter criteria do you see on the first page of https://www.dasweltauto.at?");
        question.setAnswers(new String[]{"50", "3", "10"});
        question.setCorrectAnswer(2);
        questions.add(question);

        question.setQuestion(
            "In which field of our Digital Innovation department is the virtual testdrive application situated?");
        question.setAnswers(new String[]{"Virtual Reality", "Artificial Intelligence", "Big Data"});
        question.setCorrectAnswer(0);
        questions.add(question);

    }

    public Question getQuestion(int currentQuestion)
    {
        return questions.get(currentQuestion);
    }

    public int size()
    {
        return questions.size();
    }
}
