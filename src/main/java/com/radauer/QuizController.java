package com.radauer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andreas on 17.04.2017.
 */
@RestController
public class QuizController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ResultService resultService;

    @Autowired
    private RestTemplate restTemplate;

    private Questions questions = new Questions();

    @RequestMapping("/quiz")
    public QuizResult answer(@RequestParam(value = "q", required = false) Integer question,
                             @RequestParam(value = "a", required = false) Integer answer) {

        QuizSession quizSession = getQuizSession();
        if (quizSession == null) {
            return createMessageResult("Start the Quiz", false);
        }

        if (question == null) {
            return createResult(quizSession, "Answer to which Question?");
        }
        if (answer == null) {
            return createMessageResult("No answer found!", true);
        }

        if (question != quizSession.getCurrentQuestion()) {
            return createResult(quizSession, "Wrong question!");
        }

        boolean correct = evaluateAnswer(answer, quizSession);
        return createResult(quizSession, correct ? "Correct!" : "Wrong!");
    }

    @RequestMapping("/start")
    public QuizResult start() {


        QuizSession qs = new QuizSession();
        qs.setQuizStart(System.currentTimeMillis());
        qs.setPoints(0);

        httpSession.setAttribute("quizSession", qs);

        return createResult(qs, "Start!");
    }


    @RequestMapping("/submit")
    public QuizResult start(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
                            @RequestParam(value = "company") String company, @RequestParam(value = "token") String token) {


        if(!testCaptcha(token)){
            QuizResult result = new QuizResult();
            result.setMessage("Captcha not valid!");
            result.setStarted(true);
            result.setFinished(true);
            return result;
        }
        if (resultService.containsEmail(email)) {
            QuizResult result = new QuizResult();
            result.setMessage("You have already participated!");
            result.setStarted(true);
            result.setFinished(true);
            return result;
        }


        QuizSession qs = getQuizSession();
        if (qs == null) {
            return createMessageResult("Start the Quiz", false);
        }
        if(!qs.isFinished()){
            return createMessageResult("You have not finished the Quiz", true);
        }

        httpSession.setAttribute("quizSession", qs);

        resultService.addResult(
                new Result(name, email,  company, qs.getPoints(), qs.getTimeInSeconds()));

        httpSession.invalidate();
        QuizResult result = new QuizResult();
        result.setMessage("Thank you for participating!");
        result.setFinished(true);
        result.setStarted(true);
        result.setSubmitted(true);
        return result;
    }

    private boolean testCaptcha(String token){
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("secret", "6LfdoCAUAAAAAEwRULJx_y4jfU2q65oHGNQ0hP-f");
        params.add("response", token);

        System.out.println("Test Token: "+token);
        RecaptchaResponse recaptchaResponse = restTemplate.postForObject("https://www.google.com/recaptcha/api/siteverify", params, RecaptchaResponse.class);

        System.out.println("Response: "+recaptchaResponse);
        if(recaptchaResponse.success){
            return true;
        }
        return false;
    }


    @RequestMapping("/result")
    public List<ResultTo> result() {

        return resultService.getResults();
    }

    private boolean evaluateAnswer(int answer, QuizSession quizSession) {
        Question question = questions.getQuestion(quizSession.getCurrentQuestion());
        quizSession.setCurrentQuestion(quizSession.getCurrentQuestion() + 1);
        if (question.getCorrectAnswer() == answer) {
            quizSession.setPoints(quizSession.getPoints() + 1);
            return true;
        }
        return false;
    }

    private QuizResult createResult(QuizSession session, String message) {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        result.setFinished(false);
        result.setStarted(true);


        result.setPoints(session.getPoints());
        result.setTimeInSeconds((int) ((System.currentTimeMillis() - session.getQuizStart()) / 1000));
        result.setCurrentQuestion(session.getCurrentQuestion());
        result.setNumberOfQuestions(questions.size());
        if (session.getCurrentQuestion() >= questions.size()) {
            result.setMessage(result.getMessage());
            result.setFinished(true);
            session.setFinished(true);
            session.setTimeInSeconds(result.getTimeInSeconds());

        } else {
            fillQuestion(result, session);
        }

        return result;
    }



    private void fillQuestion(QuizResult result, QuizSession session) {

        Question question = questions.getQuestion(session.getCurrentQuestion());
        result.setQuestion(question.getQuestion());
        result.setAnswers(question.generateAnswersForResult());
    }


    private QuizResult createMessageResult(String message, boolean started) {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        result.setStarted(started);
        return result;
    }

    private QuizSession getQuizSession() {
        return (QuizSession) httpSession.getAttribute("quizSession");
    }
}
