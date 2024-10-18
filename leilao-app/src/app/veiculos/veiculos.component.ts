import { Component, OnInit } from '@angular/core';
import { VeiculosService } from './veiculos.service';
import { Veiculo } from './veiculo.model';

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent implements OnInit {
  veiculos: Veiculo[] = [];

  constructor(private veiculosService: VeiculosService) {}

  ngOnInit() {
    this.veiculosService.getVeiculos().subscribe(
      data => {
        this.veiculos = data;
      },
      error => {
        console.error('Erro ao buscar veículos', error);
      }
    );
  }
}
