import { Component, OnInit } from '@angular/core';
import { ImoveisService } from './imoveis.service';
import { Imovel } from './imovel.model';

@Component({
  selector: 'app-imoveis',
  templateUrl: './imoveis.component.html',
  styleUrls: ['./imoveis.component.css']
})
export class ImoveisComponent implements OnInit {
  imoveis: Imovel[] = [];

  constructor(private imoveisService: ImoveisService) {}

  ngOnInit() {
    this.imoveisService.getImoveis().subscribe(
      data => {
        this.imoveis = data;
      },
      error => {
        console.error('Erro ao buscar imóveis', error);
      }
    );
  }
}
