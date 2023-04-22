package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Devolucao;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.service.DevolucaoService;
import br.com.fafic.ppi.nossaBiblioteca.service.EmprestimoService;
import br.com.fafic.ppi.nossaBiblioteca.service.LivroService;
import javax.validation.Valid;
import javax.validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devolucao")
@RequiredArgsConstructor
public class DevolucaoController {

    private final DevolucaoService devolucaoService;
    private final LivroService livroService;
    private Validator validator;


    @GetMapping
    public List<Devolucao> findAll(){
        return devolucaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucao> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(devolucaoService.findById(id));
    }
}
