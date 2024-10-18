import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Instituicao } from '../models/instituicao.model';

@Injectable({
  providedIn: 'root'
})
export class InstituicaoService {
  private apiUrl = 'http://localhost:8080/api/instituicoes'; // URL para o endpoint de instituições financeiras

  constructor(private http: HttpClient) {}

  getInstituicoes(): Observable<Instituicao[]> {
    return this.http.get<Instituicao[]>(this.apiUrl);
  }

  getInstituicaoById(id: number): Observable<Instituicao> {
    return this.http.get<Instituicao>(`${this.apiUrl}/${id}`);
  }

  createInstituicao(instituicao: Instituicao): Observable<Instituicao> {
    return this.http.post<Instituicao>(this.apiUrl, instituicao);
  }

  updateInstituicao(id: number, instituicao: Instituicao): Observable<Instituicao> {
    return this.http.put<Instituicao>(`${this.apiUrl}/${id}`, instituicao);
  }

  deleteInstituicao(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
