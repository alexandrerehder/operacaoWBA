package br.wba.operacao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OperacaoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private BigDecimal valorTotal;
  @NotNull
  private BigDecimal multa;
  @NotNull
  private LocalDate dataOperacao;
  @NotNull
  private List<TituloDTO> listaDeTitulos;
  
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
public List<TituloDTO> getListaDeTitulos() {
	return listaDeTitulos;
}
public void setListaDeTitulos(List<TituloDTO> listaDeTitulos) {
	this.listaDeTitulos = listaDeTitulos;
}
public BigDecimal getMulta() {
	return multa;
}
public void setMulta(BigDecimal multa) {
	this.multa = multa;
}
}
