import { Component, OnInit } from '@angular/core';
import { ListaCnesService } from 'src/app/services/lista-cnes.service';

@Component({
  selector: 'app-lista-cnes',
  templateUrl: './lista-cnes.component.html',
  styleUrls: ['./lista-cnes.component.css']
})
export class ListaCNESComponent implements OnInit {
  
  loader = true;
  exibirPesquisa = false;
  exibirEstados   = false;
  exibirTipoGestao = false;
  exibirTipos    = false;
  tipoEstado = '';
  tipoGestao = '';
  opcaoSelecionada = ''
  progesso = false;

  //LISTAS
  registros  : any = [];
  estados    : any = [];
  tiposGestao: any = [];

  pag : Number = 1 ;
  contador : Number = 100;

  constructor(private listaCnesService : ListaCnesService) { 
    this.estados     = this.listaCnesService.listarTodosEstados();
    this.tiposGestao = this.listaCnesService.listarTodosTiposGestao();
  }

  teste(event){
    console.log(event.value);
  }

  ngOnInit(): void {
    this.exibirPesquisa = false;
    this.exibirEstados  = true;
    this.exibirTipoGestao = true;
    this.exibirTipos    = false;
  }

  selecionar(opcao){
    this.limpar();
    this.opcaoSelecionada = opcao;
    this.exibirPesquisa = true;
  }

  limpar(){
    this.registros = [];
    this.loader = true;
    this.exibirPesquisa = false;
    this.exibirTipos    = false;
    this.tipoEstado = '';
    this.tipoGestao = '';
    this.opcaoSelecionada = ''
    this.progesso = false;

  }

  buscarResultado(){
    this.progesso = true;
    if(this.opcaoSelecionada == 'todos'){
      this.buscarTodosRegistros();
    }else if(this.opcaoSelecionada == 'estado' && this.tipoEstado != '' ){
      this.buscarRegistrosPorEstado();
    }else{
      this.buscarRegistrosPorTipoOrgao();
    }
  }  

  buscarRegistrosPorTipoOrgao(){
    this.listaCnesService.listarRegistrosPorOrgao(this.tipoGestao).subscribe((res) => {
      this.registros = res;
      this.loader = false;
      this.progesso = false; 
    })
  }

  /**
   * Buscar registros por estado.
   */
  buscarRegistrosPorEstado(){
    this.listaCnesService.listarRegistrosPorEstado(this.tipoEstado).subscribe((res) => {
      this.registros = res;
      this.loader = false;
      this.progesso = false;
    })
  }

  /**
   * Buscar todos registros CNES
   */
  buscarTodosRegistros(){
    this.listaCnesService.listarTodos().subscribe((res) => {
      this.registros = res;
      this.loader = false;
      this.progesso = false;
    })
  }
}
