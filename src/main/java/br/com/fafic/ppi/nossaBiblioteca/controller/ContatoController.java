package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.service.ContatoService;
import javax.validation.Valid;
import javax.validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private Validator validator;



    @GetMapping
    public List<Contato> findAll(){
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(contatoService.findById(id));
    }
}
