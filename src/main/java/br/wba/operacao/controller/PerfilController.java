package br.wba.operacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wba.operacao.dto.PerfilDTO;
import br.wba.operacao.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {
	
	@Autowired
    private PerfilService perfilService;
	
	@GetMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(perfilService.buscarListaPerfis(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(perfilService.buscarPerfilPorId(id), HttpStatus.OK);
    }
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cadastrarPerfil(@RequestBody PerfilDTO dto) {
    	return new ResponseEntity<>(perfilService.criarUsuario(dto), HttpStatus.CREATED);	
    }
	
	@DeleteMapping(value = "/deletar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removerPerfil(@PathVariable("id") Integer id) {
		perfilService.deletarPerfil(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    } 
}
