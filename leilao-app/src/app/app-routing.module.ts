import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { ImoveisComponent } from './imoveis/imoveis.component';
import { VeiculosComponent } from './veiculos/veiculos.component';
import { LeiloesComponent } from './leiloes/leiloes.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redireciona para a página de login ao abrir
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'imoveis', component: ImoveisComponent },
  { path: 'veiculos', component: VeiculosComponent },
  { path: 'leiloes', component: LeiloesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
