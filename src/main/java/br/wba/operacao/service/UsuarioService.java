package br.wba.operacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.wba.operacao.domain.Usuario;
import br.wba.operacao.dto.UsuarioDTO;
import br.wba.operacao.exceptionhandler.DataNotFoundException;
import br.wba.operacao.mapper.UsuarioTransformMapper;
import br.wba.operacao.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioTransformMapper mapper;
	
	@Transactional
	public List<Usuario> buscarListaUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioDTO buscarUsuariolPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
	    return mapper.toDTO(usuario.orElseThrow(() -> new DataNotFoundException()));
	}

	
	@Transactional
	public UsuarioDTO criarUsuario(UsuarioDTO dto) {
		Usuario usuario = mapper.toEntity(dto);
		return mapper.toDTO(usuarioRepository.save(usuario));
	}
	
	@Transactional
	public void deletarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	  }
}
