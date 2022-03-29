package br.wba.operacao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TituloDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @NotNull
  private LocalDate dataVencimento;
  @NotNull
  private BigDecimal valor;
  private Integer prazo;
  
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getPrazo() {
		return prazo;
	}
	public void setPrazo(Integer prazo) {
	this.prazo = prazo;								
}
}