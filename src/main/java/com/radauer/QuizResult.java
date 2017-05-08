package com.radauer;

/**
 * Created by Andreas on 17.04.2017.
 */
public class QuizResult
{


    private String message;
    private boolean finished;
    private boolean started;
    private boolean submitted;

    private boolean lastAnswerCorrect;
    private int currentQuestion;
    private int numberOfQuestions;
    private String question;
    private Answer[] answers;
    private int timeInSeconds;
    private int points;

    public int getCurrentQuestion()
    {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Answer[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(Answer[] answers)
    {
        this.answers = answers;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }


    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void setFinished(boolean finished)
    {
        this.finished = finished;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isLastAnswerCorrect() {
        return lastAnswerCorrect;
    }

    public void setLastAnswerCorrect(boolean lastAnswerCorrect) {
        this.lastAnswerCorrect = lastAnswerCorrect;
    }
}
