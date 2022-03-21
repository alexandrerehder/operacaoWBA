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

    operacao.setValorTotal(operacao.getListaDeTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
    return mapper.toDTO(operacaoRepository.save(operacao));
  }

//  @Transactional
//  public void deleteOperacao(Integer id) {
//    operacaoRepository.deleteById(id);
//  }
//
//  @Transactional
//  public void calculaNovosPrazos(Integer id, LocalDate novaDataOperacao) {
//    Operacao operacao = getOperacaoById(id);
//    List<Titulo> lista = operacao.getListaDeTitulos();
//    for (Titulo obj : lista) {
//      long calcPrazo = ChronoUnit.DAYS.between(novaDataOperacao, obj.getDataVencimento());
//      obj.setPrazo((int) calcPrazo);
//    }
//  }
//
//  @Transactional
//  public void calculaNovoValorTotal(Titulo obj, Operacao operacao) {
//    BigDecimal valorTotal = BigDecimal.ZERO;
//    valorTotal = operacao.getValorTotal();
//    valorTotal = valorTotal.add(obj.getValor());
//    operacao.setValorTotal(valorTotal);
//  }
}
