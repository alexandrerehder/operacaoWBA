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
  
  private UsuarioDTO usuario;
  

}
