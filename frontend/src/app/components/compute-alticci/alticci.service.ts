import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlticciService {

  constructor(private http: HttpClient) { }

  private readonly API = 'http://localhost/api';

  computeElement(n: number): Observable<number> {
    return this.http.get<number>(`${this.API}/${n}`);
  }
}
