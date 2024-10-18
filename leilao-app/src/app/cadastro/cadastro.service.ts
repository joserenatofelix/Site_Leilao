import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {
  private apiUrl = 'http://localhost:8080/api/usuarios'; // URL do seu endpoint de cadastro

  constructor(private http: HttpClient) {}

  cadastrarUsuario(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }
}
