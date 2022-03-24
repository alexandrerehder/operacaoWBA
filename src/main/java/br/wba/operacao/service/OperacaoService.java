package br.wba.operacao.service;

import br.wba.operacao.domain.Operacao;
import br.wba.operacao.domain.Titulo;
import br.wba.operacao.dto.OperacaoDTO;
import br.wba.operacao.mapper.OperacaoTransformMapper;
import br.wba.operacao.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OperacaoService {

  @Autowired
  private OperacaoRepository operacaoRepository;

  @Autowired
  OperacaoTransformMapper mapper;

  @Transactional
  public List<OperacaoDTO> getListOperacoes() {
    return mapper.toListDTO(operacaoRepository.findAll());
  }

  public OperacaoDTO getOperacaoById(Integer id) {
    return mapper.toDTO(operacaoRepository.findById(id));
  }

  @Transactional
  public OperacaoDTO createOperacao(OperacaoDTO dto) {
    Operacao operacao = mapper.toEntity(dto);
  
    LocalDate dataOperacao = operacao.getDataOperacao();
    List<Titulo> lista = operacao.getListaDeTitulos();

    for (Titulo titulo : lista) {
      titulo.setOperacao(operacao);
      long calcPrazo = ChronoUnit.DAYS.between(dataOperacao, titulo.getDataVencimento());
      titulo.setPrazo((int) calcPrazo);
    }
    
    BigDecimal valorTitulos = (operacao.getListaDeTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
    valorTitulos = valorTitulos.add(operacao.getValorMulta());
    operacao.setValorTotal(valorTitulos);
 	  return mapper.toDTO(operacaoRepository.save(operacao));
  }
   
  @Transactional
  public OperacaoDTO alteraOperacao(OperacaoDTO dto) {
	  Operacao operacao = operacaoRepository.findById(dto.getId());
	  operacao.setDataOperacao(dto.getDataOperacao());
	  
	  List<Titulo> lista = operacao.getListaDeTitulos();
	    for (Titulo obj : lista) {
	      long calcPrazo = ChronoUnit.DAYS.between(operacao.getDataOperacao(), obj.getDataVencimento());
	      obj.setPrazo((int) calcPrazo);
	    }
	  
	  return mapper.toDTO(operacaoRepository.save(operacao));
  }
   
  @Transactional
  public void deleteOperacao(Integer id) {
    operacaoRepository.deleteById(id);
  }
}
