import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Leilao } from './leilao.model';

@Injectable({
  providedIn: 'root'
})
export class LeiloesService {
  private apiUrl = 'http://localhost:8080/api/leiloes'; // URL do seu endpoint de leilões

  constructor(private http: HttpClient) {}

  getLeiloes(): Observable<Leilao[]> {
    return this.http.get<Leilao[]>(this.apiUrl);
  }
}
