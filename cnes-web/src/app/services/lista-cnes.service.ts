import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListaCnesService {

  constructor(private https : HttpClient) {

  }

  /**
   * Recuperar todos registros importados sobre CNES
   */
  listarTodos(){
    return this.https.get('http://localhost:8080/api/arquivos/');
  }

  /**
   * Recuperar todos registros por estado
   * @param sigla - representa a sigla do estado selecionado.
   */
  listarRegistrosPorEstado(sigla : string){
    return this.https.get('http://localhost:8080/api/arquivos/' + sigla);
  }

  /**
   * Recuperar todos registros por orgão
   * @param orgao 
   */
  listarRegistrosPorOrgao(orgao : string){
    return this.https.get('http://localhost:8080/api/arquivos/orgaos/' + orgao);
  }

  /**
   * Recuperar todos os orgãos
   */
  recuperarTodosOrgaos(){
    return this.https.get('http://localhost:8080/api/arquivos/orgaos');
  }

  listarTodosTiposGestao(){
    return [
      {"nome": "Estadual", "sigla": "E"},
      {"nome": "Municipal", "sigla": "M"}
    ]
  }

  /**
   * Recuperar todos estados brasileiros
   */
  listarTodosEstados(){
    return [
      {"nome": "Acre", "sigla": "AC"},
      {"nome": "Alagoas", "sigla": "AL"},
      {"nome": "Amapá", "sigla": "AP"},
      {"nome": "Amazonas", "sigla": "AM"},
      {"nome": "Bahia", "sigla": "BA"},
      {"nome": "Ceará", "sigla": "CE"},
      {"nome": "Distrito Federal", "sigla": "DF"},
      {"nome": "Espírito Santo", "sigla": "ES"},
      {"nome": "Goiás", "sigla": "GO"},
      {"nome": "Maranhão", "sigla": "MA"},
      {"nome": "Mato Grosso", "sigla": "MT"},
      {"nome": "Mato Grosso do Sul", "sigla": "MS"},
      {"nome": "Minas Gerais", "sigla": "MG"},
      {"nome": "Pará", "sigla": "PA"},
      {"nome": "Paraíba", "sigla": "PB"},
      {"nome": "Paraná", "sigla": "PR"},
      {"nome": "Pernambuco", "sigla": "PE"},
      {"nome": "Piauí", "sigla": "PI"},
      {"nome": "Rio de Janeiro", "sigla": "RJ"},
      {"nome": "Rio Grande do Norte", "sigla": "RN"},
      {"nome": "Rio Grande do Sul", "sigla": "RS"},
      {"nome": "Rondônia", "sigla": "RO"},
      {"nome": "Roraima", "sigla": "RR"},
      {"nome": "Santa Catarina", "sigla": "SC"},
      {"nome": "São Paulo", "sigla": "SP"},
      {"nome": "Sergipe", "sigla": "SE"},
      {"nome": "Tocantins", "sigla": "TO"}
    ]
  }
}