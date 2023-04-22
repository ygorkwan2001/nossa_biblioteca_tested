package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.dto.EmprestimoDTO;
import br.com.fafic.ppi.nossaBiblioteca.service.*;
import javax.validation.Valid;
import javax.validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;
    private Aluno aluno;

    private Validator validator;

    @GetMapping
    public List<Aluno> findAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(alunoService.findById(id));
    }
    @PostMapping("/emprestimo")
    public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO, Long livro, Long alunoid){
        emprestimoDTO.setLivro(livroService.findById(livro));
        emprestimoDTO.setAluno(alunoService.findById(alunoid));
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimoDTO));
    }
}
