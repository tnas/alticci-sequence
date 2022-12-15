import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from './../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AlticciService {

  constructor(private http: HttpClient) { }

  computeElement(n: number): Observable<number> {
    return this.http.get<number>(`${environment.apiUrl}/${n}`);
  }
}
