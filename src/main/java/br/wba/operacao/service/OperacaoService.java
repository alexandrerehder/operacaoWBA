package br.wba.operacao.service;

import br.wba.operacao.domain.Operacao;
import br.wba.operacao.dto.OperacaoDTO;
import br.wba.operacao.mapper.OperacaoTransformMapper;
import br.wba.operacao.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperacaoService {

  @Autowired
  private OperacaoRepository operacaoRepository;

  @Autowired
  OperacaoTransformMapper mapper;

  public List<OperacaoDTO> getListOperacoes() {
    return mapper.toListDTO(operacaoRepository.findAll());
  }

  public OperacaoDTO getOperacaoById(Integer id) {
    return mapper.toDTO(operacaoRepository.findById(id));
  }

  public OperacaoDTO createOperacao(OperacaoDTO dto) {
    Operacao operacao = mapper.toEntity(dto);
 	  return mapper.toDTO(operacaoRepository.save(operacao));
  }
   
  public OperacaoDTO alteraOperacao(OperacaoDTO dto) {
	  Operacao operacao = operacaoRepository.findById(dto.getId());
	  Operacao operacaoAlterada = mapper.merge(operacao, dto);
	  return mapper.toDTO(operacaoRepository.save(operacaoAlterada));
  }
   
  @Transactional
  public void deleteOperacao(Integer id) {
    operacaoRepository.deleteById(id);
  }
}
