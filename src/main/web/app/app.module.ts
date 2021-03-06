import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {AppRoutes} from "./app.routes";
import {QuizComponent} from "./quiz/quiz.component";
import {QuizService} from "./quiz/quiz.service";
import { QuizLoginComponent } from './quiz-login/quiz-login.component';
import { QuizResultComponent } from './quiz-result/quiz-result.component';
import { ImprintComponent } from './imprint/imprint.component';
import { CountdownComponent } from './countdown/countdown.component';
import { ReCaptchaModule } from 'angular2-recaptcha';


@NgModule({
    declarations: [
        AppComponent,
        QuizComponent,
        QuizLoginComponent,
        QuizResultComponent,
        ImprintComponent,
        CountdownComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(AppRoutes),
        ReCaptchaModule
    ],
    providers: [
        QuizService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
