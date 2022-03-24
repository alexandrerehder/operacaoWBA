package br.wba.operacao.mapper;

import br.wba.operacao.domain.Operacao;
import br.wba.operacao.dto.OperacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OperacaoTransformMapper {
	
	@Mapping(source = "valorMulta", target = "multa")
    public abstract OperacaoDTO toDTO(Operacao operacao);

    @Mapping(source = "multa", target = "valorMulta", qualifiedByName = "roudingModeValorMulta")
    public abstract Operacao toEntity(OperacaoDTO dto);
    
    public abstract List<OperacaoDTO> toListDTO(List<Operacao> all);
    
    @Named("roudingModeValorMulta")
	public BigDecimal setRoudingMode(BigDecimal multa) {
		return multa.setScale(2, RoundingMode.HALF_UP);
	}
}
