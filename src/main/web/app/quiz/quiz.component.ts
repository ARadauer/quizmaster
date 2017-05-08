import {Component, OnInit} from "@angular/core";
import {QuizService} from "./quiz.service";
import {QuizResult, Answer} from "../../typings/fcc";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-quiz',
    templateUrl: './quiz.component.html',
    styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {

    onLoadErrorMsg:string;
    quizResult:QuizResult;


    constructor(private quizService:QuizService) {
        setInterval(() => {
            if (this.quizResult && this.quizResult.started && !this.quizResult.finished) {
                this.quizResult.timeInSeconds++
            }
        }, 1000);
    }

    ngOnInit() {
        this.onRestart();
    }

    onRestart(){
        this.quizResult = <QuizResult>{
            message: 'Start our quiz to win some awesome prizes:',
            started: false
        };
    }

    onStart(){
        this.quizService.start().subscribe(
            quizResult => {
                this.quizResult = quizResult;
                console.log('quizresult', this.quizResult);
            },
            error => this.onLoadErrorMsg = <any>error);
    }



    showWrong(){
        return this.quizResult.message.indexOf('Wrong') == 0;
    }

    showCorrect(){
        return this.quizResult.message.indexOf('Correct') == 0;
    }

    getAlertStyle(){
        if(this.showCorrect()){
            return 'alert-success';
        }else if(this.showWrong()){
            return 'alert-danger';
        }else{
            return 'alert-info';
        }
    }


    handleSubmit(quizResult:QuizResult) {
        console.log('handleLogin', quizResult);
        this.quizResult = quizResult;
    }


    onGiveAnswer(answer:Answer) {
        console.log('answer', answer);
        this.quizService.answer(answer, this.quizResult.currentQuestion).subscribe(
            quizResult => {
                this.quizResult = quizResult;
                console.log('quizresult', this.quizResult);
            },
            error => this.onLoadErrorMsg = <any>error);
    }


}