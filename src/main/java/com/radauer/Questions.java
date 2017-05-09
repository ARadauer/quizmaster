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

        Question q1 = new Question();
        q1.setQuestion("How many digitisation experts are working for Porsche Informatik?");
        q1.setAnswers(new String[]{"42", "450", "0111001"});
        q1.setCorrectAnswer(1);
        questions.add(q1);

        Question q2 = new Question();
        q2.setQuestion("How many filter criteria do you see on the first page of www.dasweltauto.at?");
        q2.setAnswers(new String[]{"50", "3", "10"});
        q2.setCorrectAnswer(2);
        questions.add(q2);

        Question q3 = new Question();
        q3.setQuestion(
            "In which field of our Digital Innovation department is the virtual testdrive application situated?");
        q3.setAnswers(new String[]{"Virtual Reality", "Artificial Intelligence", "Big Data"});
        q3.setCorrectAnswer(0);
        questions.add(q3);

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
