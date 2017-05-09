import {Component, OnInit, OnDestroy} from "@angular/core";
import {Observable, Subscription} from "rxjs/Rx";
import {QuizService} from "../quiz/quiz.service";

@Component({
    selector: 'quiz-countdown',
    template: `
  <div *ngIf="showCountDown()">
    <h4 class="well">
        <p>{{message}} until Porsche Informatik at WeAreDevelopers</p>
        <p>You'll find us at C4.05</p>
        <p>See you there!</p>
        <p>#wearedevs #porscheinformatik #smartmobility</p>
    </h4>
  </div>
`
})
export class CountdownComponent implements OnInit, OnDestroy {

    private future: Date;

    private diff: number;
    private $counter: Observable<number>;
    private subscription: Subscription;
    private message: string;

    constructor(private quizService: QuizService) {

    }

    dhms(t) {
        var days, hours, minutes, seconds;
        days = Math.floor(t / 86400);
        t -= days * 86400;
        hours = Math.floor(t / 3600) % 24;
        t -= hours * 3600;
        minutes = Math.floor(t / 60) % 60;
        t -= minutes * 60;
        seconds = t % 60;

        return [
            days + 'd',
            hours + 'h',
            minutes + 'm',
            seconds + 's'
        ].join(' ');
    }

    showCountDown() {
        return !this.quizService.isQuizActive();
    }

    ngOnInit() {
        this.future = this.quizService.activeDate;
        if (this.quizService.isQuizActive()) {
            return;
        }


            this.$counter = Observable.interval(1000).map((x) => {
                this.diff = Math.floor((this.future.getTime() - new Date().getTime()) / 1000);
                return x;
            });

            this.subscription = this.$counter.subscribe((x) => this.message = this.dhms(this.diff));


    }

    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
}