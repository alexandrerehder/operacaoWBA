package br.wba.operacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PerfilDTO implements Serializable {

	  private static final long serialVersionUID = 1L;

	  private Integer id;
	  @NotNull
	  private String tipo;
	  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
