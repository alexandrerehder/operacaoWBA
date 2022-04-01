package br.wba.operacao.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioConfiguracaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Boolean visualizaTela;

	
}
