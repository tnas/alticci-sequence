import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlticciService {

  private readonly API = ' /api';

  constructor(private http: HttpClient) { }

  computeElement(n: number): Observable<number> {
    return this.http.get<number>(`${this.API}/${n}`);
  }
}
