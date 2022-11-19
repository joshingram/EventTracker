import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Trail } from '../models/trail';

@Injectable({
  providedIn: 'root'
})
export class TrailService {

  baseUrl = 'http://localhost:8085/'
  url = this.baseUrl + 'api/trails'
  constructor(
    private http: HttpClient
  ) { }

  // getHttpOptions() {
  //   let options = {
  //     headers: {
  //       Authorization: 'Basic ' + this.auth.getCredentials(),
  //       'X-Requested-With': 'XMLHttpRequest',
  //     },
  //   };
  //   return options;
  // }

  index(): Observable<Trail[]> {
    return this.http.get<Trail[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TrailService.index(): error retrieving trails: ' + err)
        );
      })
    );
  }

  show(trailId: number): Observable<Trail> {
    return this.http.get<Trail>(this.url+ '/' +trailId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TrailService.index(): error retrieving trail: ' + err)
        );
      })
    );
  }

  create(trail: Trail): Observable<Trail> {
    return this.http.post<Trail>(this.url, trail).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
           () => new Error( 'Trail.create(): error creating Trail: ' + err )
        );
      })
    );
  }

  update(id: number, trail: Trail): Observable<Trail> {
    return this.http.put<Trail>(this.url + '/' + id, trail).pipe(
      catchError((err:any)=>{
        console.error(err);
        return throwError(
          ()=> new Error('Trail.update(): error updating Trail: ' +err)
        );
      })
    );
  }

  destroy(trailId: number): Observable<void> {
    // return this.http.delete<void>(this.url +'/'+ trailId, this.getHttpOptions()).pipe();
    return this.http.delete<void>(this.url +'/'+ trailId).pipe();
  }

}
