package br.wba.operacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.wba.operacao.domain.Perfil;
import br.wba.operacao.dto.PerfilDTO;
import br.wba.operacao.exceptionhandler.DataNotFoundException;
import br.wba.operacao.mapper.PerfilTransformMapper;
import br.wba.operacao.repository.PerfilRepository;


@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	PerfilTransformMapper mapper;
	
	public List<PerfilDTO> buscarListaPerfis() {
		return mapper.toListDTO(perfilRepository.findAll());
	}
	
	public PerfilDTO buscarPerfilPorId(Integer id) {
		Optional<Perfil> perfil = perfilRepository.findById(id);
	    return mapper.toDTO(perfil.orElseThrow(() -> new DataNotFoundException()));
	}

	public PerfilDTO criarPerfil(PerfilDTO dto) {
		Perfil perfil = mapper.toEntity(dto);
		return mapper.toDTO(perfilRepository.save(perfil));
	}
	
	 @Transactional
	 public void deletarPerfil(Integer id) {
		  perfilRepository.deleteById(id);
	 }
}
