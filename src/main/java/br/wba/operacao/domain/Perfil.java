package br.wba.operacao.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {

	  private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;
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
