package br.wba.operacao.repository;


import br.wba.operacao.domain.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, UUID> {

    Operacao findById(@Param("id") Integer id);

    void deleteById(Integer id);
}
