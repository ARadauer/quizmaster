import {Routes} from "@angular/router";
import {QuizComponent} from "./quiz/quiz.component";
import {QuizResultComponent} from "./quiz-result/quiz-result.component";
import {ImprintComponent} from "./imprint/imprint.component";

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'page/quiz',
    pathMatch: 'full'
  },
  {
    path: 'index',
    redirectTo: 'page/quiz',
    pathMatch: 'full'
  },
  {
    path: 'page/quiz',
    component: QuizComponent
  },
  {
    path: 'page/results',
    pathMatch: 'full',
    component: QuizResultComponent
  },
  {
    path: 'page/imprint',
    pathMatch: 'full',
    component: ImprintComponent
  }
];
