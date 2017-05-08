import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {QuizService} from "../quiz/quiz.service";
import {QuizResult} from "../../typings/fcc";

@Component({
  selector: 'app-quiz-login',
  templateUrl: './quiz-login.component.html',
  styleUrls: ['./quiz-login.component.scss']
})
export class QuizLoginComponent implements OnInit {

  constructor(private quizService: QuizService) { }

  @Output() afterLogin = new EventEmitter<QuizResult>();

  user: string;
  email : string;
  company: string;

  showTerms: boolean = false;

  ngOnInit() {
  }

  public toggleTerms(){
    this.showTerms = !this.showTerms;
  }

  onSubmit(){
    this.quizService.submit(this.user, this.email, this.company).subscribe(quizResult => {
      this.afterLogin.emit(quizResult);
    });
  }


}
