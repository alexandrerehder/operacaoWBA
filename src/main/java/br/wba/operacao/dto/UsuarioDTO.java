package br.wba.operacao.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.wba.operacao.domain.Perfil;
import lombok.Data;


@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String username;
	
	@NotNull
	private String senha;
	
	@NotNull
	private List<Perfil> perfis;
	
	private UsuarioConfiguracaoDTO configuracaoUsuario;
	

	
	
}
