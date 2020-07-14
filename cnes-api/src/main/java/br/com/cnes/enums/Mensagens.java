package br.com.cnes.enums;

import lombok.Getter;

/**
 * 
 * @author jaircavalcante
 *
 */
public enum Mensagens {

    NENHUM_REGISTRO_ENCONTRADO("Não foi encontrado nenhum registro na base!"),
    
    NENHUM_REGISTRO_ENCONTRADO_POR_ESTADO("Não foi encontrado nenhum registro para o estado informado!"),

    NENHUM_REGISTRO_ENCONTRADO_POR_TIPO_GESTAO("Não foi encontrado nenhum registro para o tipo gestão informado!"),
    
    ARQUIVO_IMPORTADO("Arquivo Importado!");
    
 	@Getter
	private String mensagem;
	
	Mensagens(String mensagem){
		this.mensagem = mensagem;
	}
}

