package br.wba.operacao.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.wba.operacao.domain.Usuario;
import br.wba.operacao.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public abstract class UsuarioTransformMapper {
	
	public abstract UsuarioDTO toDTO(Usuario usuario);
	
	public abstract Usuario toEntity(UsuarioDTO dto);
	
	public abstract List<UsuarioDTO> toListDTO(List<Usuario> all);

}



