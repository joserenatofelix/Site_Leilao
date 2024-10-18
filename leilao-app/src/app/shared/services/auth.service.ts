import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth'; // URL para o endpoint de autenticação

  constructor(private http: HttpClient) {}

  login(credentials: { email: string, senha: string }): Observable<any> {
    return this.http.post(this.apiUrl + '/login', credentials);
  }

  logout() {
    localStorage.removeItem('token'); // Remove o token do localStorage
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token'); // Verifica se o token existe no localStorage
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  setToken(token: string) {
    localStorage.setItem('token', token); // Armazena o token no localStorage
  }
}
