import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Veiculo } from './veiculo.model';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
  private apiUrl = 'http://localhost:8080/api/veiculos'; // URL do seu endpoint de veículos

  constructor(private http: HttpClient) {}

  getVeiculos(): Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.apiUrl);
  }
}
