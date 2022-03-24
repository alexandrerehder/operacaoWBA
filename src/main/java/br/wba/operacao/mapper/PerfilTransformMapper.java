package br.wba.operacao.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.wba.operacao.domain.Perfil;
import br.wba.operacao.dto.PerfilDTO;

@Mapper(componentModel = "spring")
public abstract class PerfilTransformMapper {
	
	public abstract PerfilDTO toDTO(Perfil perfil);
	
	public abstract Perfil toEntity(PerfilDTO dto);
	
	public abstract List<PerfilDTO> toListDTO(List<Perfil> all);

}
