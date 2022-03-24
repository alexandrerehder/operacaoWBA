package br.wba.operacao.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class OperacaoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private BigDecimal valorTotal;
  private BigDecimal multa;
  private LocalDate dataOperacao;
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
