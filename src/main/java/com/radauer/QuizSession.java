package com.radauer;

import java.io.Serializable;

/**
 * Created by Andreas on 17.04.2017.
 */
public class QuizSession implements Serializable
{


    private long quizStart;
    private int timeInSeconds;
    private int currentQuestion;
    private int points;

    private boolean finished;



    public long getQuizStart()
    {
        return quizStart;
    }

    public void setQuizStart(long quizStart)
    {
        this.quizStart = quizStart;
    }

    public int getCurrentQuestion()
    {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString()
    {
        return "QuizSession{"
                   + ", quizStart="
            + quizStart
            + ", currentQuestion="
            + currentQuestion
            + ", points="
            + points
            + '}';
    }
}
