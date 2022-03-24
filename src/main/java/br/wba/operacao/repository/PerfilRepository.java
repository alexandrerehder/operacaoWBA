package br.wba.operacao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.wba.operacao.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {
	
	@Query("select p from Perfil p where p.id = :id")
    Optional<Perfil> findById(@Param("id") Integer id);
	
	void deleteById(Integer id);
}
