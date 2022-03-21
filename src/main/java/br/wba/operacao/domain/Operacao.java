package br.wba.operacao.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private BigDecimal valorTotal;
  private LocalDate dataOperacao;

  @OneToMany(mappedBy = "operacao", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Titulo> listaDeTitulos;
  
  	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public LocalDate getDataOperacao() {
		return dataOperacao;
	}
	
	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	
	public List<Titulo> getListaDeTitulos() {
		return listaDeTitulos;
	}
	
	public void setListaDeTitulos(List<Titulo> listaDeTitulos) {
		this.listaDeTitulos = listaDeTitulos;
	}
}