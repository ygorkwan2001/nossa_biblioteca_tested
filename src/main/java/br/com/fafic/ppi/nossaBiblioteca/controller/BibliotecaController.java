package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.dto.BibliotecaDTO;
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
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;
    private final BibliotecarioService bibliotecarioService;
    private final LivroService livroService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    private Validator validator;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid BibliotecaDTO bibliotecaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(bibliotecaDTO));
    }

    @GetMapping
    public List<Biblioteca> findAll(){
        return bibliotecaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bibliotecaService.findById(id));
    }
    @PutMapping
    public ResponseEntity update (@RequestBody BibliotecaDTO bibliotecaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(bibliotecaDTO));
    }

    @PostMapping("/{id}/bibliotecario")
    public ResponseEntity adicionarBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecario) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setBibliotecario(bibliotecarioService.findById(bibliotecario.getId()));
            bibliotecaService.save(new BibliotecaDTO());
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        bibliotecarioService.deleteBibliotecario(id);
    }
}
