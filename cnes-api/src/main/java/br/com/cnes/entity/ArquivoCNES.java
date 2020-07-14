package br.com.cnes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author jaircavalcante
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ArquivoCNES")
public class ArquivoCNES {

	@Id
	@Column(name = "COD_CNES")
	private String codigoCNES;

	@Column(name = "CO_IBGE")
	private String codigoIBGE;

	@Column(name = "NO_FANTASIA")
	private String nomeFantasia;

	@Column(name = "DS_TIPO_UNIDADE")
	private String descricaoTipoUnidade;

	@Column(name = "TP_GESTAO")
	private String tipoGestao;

	@Column(name = "NO_LOGRADOURO")
	private String numeroLogradouro;

	@Column(name = "NU_ENDERECO")
	private String numeroEndereco;

	@Column(name = "NO_BAIRRO")
	private String nomeBairro;

	@Column(name = "CO_CEP")
	private String codigoCEP;

	@Column(name = "UF")
	private String siglaEstado;

	@Column(name = "MUNICIPIO")
	private String municipio;

	@Column(name = "NU_TELEFONE")
	private String numeroTelefone;

}