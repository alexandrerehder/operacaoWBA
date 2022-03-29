package br.wba.operacao.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import br.wba.operacao.domain.Operacao;
import br.wba.operacao.dto.OperacaoDTO;

@Mapper(componentModel = "spring")
public abstract class OperacaoTransformMapper {
	
	@Mapping(source = "valorMulta", target = "multa")
    public abstract OperacaoDTO toDTO(Operacao operacao);

    @Mapping(source = "multa", target = "valorMulta", qualifiedByName = "roudingModeValorMulta")
    public abstract Operacao toEntity(OperacaoDTO dto);
    
    @Mapping(target = "valorMulta", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "valorTotal", ignore = true)
    @Mapping(target = "listaDeTitulos", ignore = true)
    public abstract Operacao merge(@MappingTarget Operacao operacao, OperacaoDTO dto);
    
    public abstract List<OperacaoDTO> toListDTO(List<Operacao> all);
    
    @Named("roudingModeValorMulta")
	public BigDecimal setRoudingMode(BigDecimal multa) {
		return multa.setScale(2, RoundingMode.HALF_UP);
	}
    
    @AfterMapping
    protected void runAfterMapping(@MappingTarget Operacao operacao) {
        operacao.populaOperacao();
        operacao.calculaPrazo();
        operacao.calculaValorTotal();
    }	
}
