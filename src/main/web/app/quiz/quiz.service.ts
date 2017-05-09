import {Injectable} from "@angular/core";
import {Http, Headers, Response, URLSearchParams} from "@angular/http";
import {Observable} from 'rxjs/Rx';
import "rxjs/add/operator/map";
import {QuizResult, Answer, ResultTo} from "../../typings/fcc";

@Injectable()
export class QuizService {
    private headers = new Headers({'Content-Type': 'application/json'});

    public activeDate = new Date(2017, 4, 11, 8);
    //public activeDate = new Date(2017, 4, 9, 9, 43);

    constructor(private http:Http) {
    }

    public isQuizActive(){
        let time = new Date().getTime() - this.activeDate.getTime();
        return time > 0;
    }

    public start():Observable<QuizResult> {
        let url = `start`;

        return this.http.get(url, {headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public submit(name:string, email:string, company:string, token: string):Observable<QuizResult> {
        let url = `submit`;

        let params = new URLSearchParams();
        params.set('name', name);
        params.set('email', email);
        params.set('company', company);
        params.set('token', token);
        return this.http.get(url, {search: params, headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public answer(answer:Answer, currentQuestion:number):Observable<QuizResult> {
        let url = `quiz`;

        let params = new URLSearchParams();
        params.set('q', currentQuestion + '');
        params.set('a', answer.number + '');

        return this.http.get(url, {search: params, headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public result():Observable<ResultTo[]> {
        let url = `result`;

        return this.http.get(url, {headers: this.headers})
            .map((res:Response) => res.json() as ResultTo[]);
    }
}
