package br.wba.operacao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.wba.operacao.domain.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
	@Query("select o from Usuario o where o.id = :id")
	Optional<Usuario> findById(@Param("id") Integer id);
	
	void deleteById(Integer id);
}