package br.wba.operacao.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	  private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;
	  @NotNull
	  private String nome;
	  @NotNull
	  private String username;
	  
	  @ManyToMany(cascade = CascadeType.MERGE)
	  @JoinTable(
			  name="PerfilUsuarios",
			  uniqueConstraints=@UniqueConstraint(columnNames = {"id_usuario", "id_perfil"}),
			  joinColumns=@JoinColumn(name="id_usuario"),
			  inverseJoinColumns=@JoinColumn(name="id_perfil")
			  ) 
	  private List<Perfil> perfis; 
	  
	  public Integer getId() {
		  return id;
	  }
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  public String getNome() {
		  return nome;
	  }
	  public void setNome(String nome) {
		  this.nome = nome;
	  }
	  public String getUsername() {
		  return username;
	  }
	  public void setUsername(String username) {
		  this.username = username;
	  }
	  public List<Perfil> getPerfis() {
		  return perfis;
	  }

	  public void setPerfis(List<Perfil> perfis) {
		  this.perfis = perfis;
	  }
}
