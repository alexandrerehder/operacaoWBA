package br.wba.operacao.controller;

import br.wba.operacao.dto.OperacaoDTO;
import br.wba.operacao.service.OperacaoService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoService operacaoService;

    @GetMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(operacaoService.getListOperacoes(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarOperacao(@PathVariable("id") Integer id) {
        OperacaoDTO dto = operacaoService.getOperacaoById(id);
        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cadastrarProduto(@RequestBody OperacaoDTO dto) {
        return new ResponseEntity<>(operacaoService.createOperacao(dto), HttpStatus.CREATED);
    }
    
    @PatchMapping(value = "/alterar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> alterarOperacao(@RequestBody OperacaoDTO dto) {
      return new ResponseEntity<>(operacaoService.alteraOperacao(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deletar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletarOperacao(@PathVariable("id") Integer id) {
    	operacaoService.deleteOperacao(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}