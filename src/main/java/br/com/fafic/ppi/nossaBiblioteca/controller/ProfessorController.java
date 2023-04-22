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
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;
    private Professor professor;



    @GetMapping
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(professorService.findById(id));
    }
    @PostMapping("/emprestimo")
    public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody @Valid EmprestimoDTO emprestimoDTO, Long professorid, Long livro){
        professorService.findById(professorid);
        livroService.findById(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimoDTO));
    }
    @PostMapping("/emprestimo/{id}/livros")
    public ResponseEntity<Emprestimo> adicionarLivroEmprestimo(@PathVariable Long id, @RequestBody Livro livro) {
        Optional<Emprestimo> optionalEmprestimo = Optional.ofNullable(emprestimoService.findById(id));
        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            livro.setEmprestimo(emprestimo);
            livroService.findById(id);
            emprestimo.setLivro(livro);
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
