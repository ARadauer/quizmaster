import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {QuizService} from "../quiz/quiz.service";
import {QuizResult} from "../../typings/fcc";
import { ViewChild } from '@angular/core';
import { ReCaptchaComponent } from 'angular2-recaptcha';

@Component({
  selector: 'app-quiz-login',
  templateUrl: './quiz-login.component.html',
  styleUrls: ['./quiz-login.component.scss']
})
export class QuizLoginComponent implements OnInit {

  constructor(private quizService: QuizService) { }

  @Output() afterLogin = new EventEmitter<QuizResult>();
  @ViewChild(ReCaptchaComponent) captcha: ReCaptchaComponent;

  user: string;
  email : string;
  company: string;

  showTerms: boolean = false;

  ngOnInit() {
  }

  public toggleTerms(){
    this.showTerms = !this.showTerms;
  }

  onSubmit() {
    let token: string = this.captcha.getResponse().toString();
    console.log('token', token);

    this.quizService.submit(this.user, this.email, this.company, token).subscribe(quizResult => {
      this.afterLogin.emit(quizResult);
    });
  }


}
