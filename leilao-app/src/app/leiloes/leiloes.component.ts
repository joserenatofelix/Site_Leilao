import { Component, OnInit } from '@angular/core';
import { LeiloesService } from './leiloes.service';
import { Leilao } from './leilao.model';

@Component({
  selector: 'app-leiloes',
  templateUrl: './leiloes.component.html',
  styleUrls: ['./leiloes.component.css']
})
export class LeiloesComponent implements OnInit {
  leiloes: Leilao[] = [];

  constructor(private leiloesService: LeiloesService) {}

  ngOnInit() {
    this.leiloesService.getLeiloes().subscribe(
      data => {
        this.leiloes = data;
      },
      error => {
        console.error('Erro ao buscar leilões', error);
      }
    );
  }
}
