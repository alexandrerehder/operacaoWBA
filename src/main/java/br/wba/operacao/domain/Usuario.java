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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	  private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;
	  private String nome;
	  private String username;
	  private String senha;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  private ConfiguracaoUsuario configuracaoUsuario;
	  
	  @ManyToMany(cascade = CascadeType.MERGE)
	  @JoinTable(
			  name="PerfilUsuarios",
			  uniqueConstraints=@UniqueConstraint(columnNames = {"id_usuario", "id_perfil"}),
			  joinColumns=@JoinColumn(name="id_usuario"),
			  inverseJoinColumns=@JoinColumn(name="id_perfil")
			  ) 
	  private List<Perfil> perfis; 
	  

}
