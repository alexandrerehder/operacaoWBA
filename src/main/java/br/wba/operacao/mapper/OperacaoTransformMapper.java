package br.wba.operacao.mapper;

import br.wba.operacao.domain.Operacao;
import br.wba.operacao.dto.OperacaoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OperacaoTransformMapper {

    public abstract OperacaoDTO toDTO(Operacao operacao);

    public abstract Operacao toEntity(OperacaoDTO dto);

    public abstract List<OperacaoDTO> toListDTO(List<Operacao> all);
}
