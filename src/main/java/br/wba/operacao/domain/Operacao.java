package br.wba.operacao.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
  private BigDecimal valorMulta;
  private LocalDate dataOperacao;
  
  @ManyToOne
  private Usuario usuario;

  @OneToMany(mappedBy = "operacao", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Titulo> listaDeTitulos;
  
  public void populaOperacao() {
	  List<Titulo> lista = this.getListaDeTitulos();
	  for (Titulo titulo : lista) {
		  titulo.setOperacao(this);
	  }
  }
  
  public void calculaPrazo() {
	  LocalDate dataOperacao = this.getDataOperacao();
	  List<Titulo> lista = this.getListaDeTitulos();
	  
	  for (Titulo titulo : lista) {
		  long calcPrazo = ChronoUnit.DAYS.between(dataOperacao, titulo.getDataVencimento());
		  titulo.setPrazo((int) calcPrazo);
	  }
  }
  
  public void calculaValorTotal() {
	  BigDecimal valorTitulos = (this.getListaDeTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
	  valorTitulos = valorTitulos.add(this.getValorMulta());
	  this.setValorTotal(valorTitulos);
  }
  
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

	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}
}