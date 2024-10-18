import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Imovel } from './imovel.model';

@Injectable({
  providedIn: 'root'
})
export class ImoveisService {
  private apiUrl = 'http://localhost:8080/api/imoveis'; // URL do seu endpoint de imóveis

  constructor(private http: HttpClient) {}

  getImoveis(): Observable<Imovel[]> {
    return this.http.get<Imovel[]>(this.apiUrl);
  }
}
