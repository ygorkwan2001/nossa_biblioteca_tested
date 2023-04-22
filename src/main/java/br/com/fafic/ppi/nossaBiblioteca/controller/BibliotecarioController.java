package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import br.com.fafic.ppi.nossaBiblioteca.dto.*;
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
@RequestMapping("/bibliotecario")
@RequiredArgsConstructor
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;
    private final LivroService livroService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final EmprestimoService emprestimoService;
    private final DevolucaoService devolucaoService;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final LoginService loginService;
    private final BibliotecaService bibliotecaService;
    private Livro livro;
    private Validator validator;

    @PostMapping
    public ResponseEntity<Bibliotecario> save(@RequestBody @Valid BibliotecarioDTO bibliotecarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecarioDTO));
    }
    @PostMapping("/aluno")
    public ResponseEntity<Aluno> saveAluno(@RequestBody @Valid AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }
    @PostMapping("/professor")
    public ResponseEntity<Professor> saveProfessor (@RequestBody @Valid ProfessorDTO professorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorDTO));
    }
    @PostMapping("/contato")
    public ResponseEntity<Contato> saveContato(@RequestBody @Valid ContatoDTO contatoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contatoDTO));
    }
    @PostMapping("/devolucao")
    public ResponseEntity<Devolucao> saveDevolucao(@RequestBody DevolucaoDTO devolucaoDTO,Long idempretimo){
        devolucaoDTO.setEmprestimo(emprestimoService.findById(idempretimo));
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucaoService.save(devolucaoDTO));
    }
    @PostMapping("/endereco")
    public ResponseEntity<Endereco> saveEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoDTO));
    }
    @PostMapping("/livro")
    public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroDTO));
    }
    @PostMapping("/login")
    public ResponseEntity<Login> saveLogin(@RequestBody @Valid LoginDTO loginDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginDTO));
    }
    @GetMapping
    public List<Bibliotecario> findAll(){
        return bibliotecarioService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bibliotecarioService.findById(id));
    }
    @PutMapping
    public ResponseEntity<Bibliotecario> updateBibliotecario (@RequestBody BibliotecarioDTO bibliotecarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecarioDTO));
    }
    @PutMapping("/aluno")
    public ResponseEntity<Aluno> updateAluno (@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }
    @PutMapping("/contato")
    public ResponseEntity<Contato> updateContato (@RequestBody ContatoDTO contatoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contatoDTO));
    }
    @PutMapping("/devolucao")
    public ResponseEntity<Devolucao> updateDevolucao (@RequestBody DevolucaoDTO devolucaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucaoService.save(devolucaoDTO));
    }
    @PutMapping("/endereco")
    public ResponseEntity<Endereco> updateEndereco (@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoDTO));
    }
    @PutMapping("/livro")
    public ResponseEntity<Livro> updateLivro (@RequestBody LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroDTO));
    }
    @PutMapping("/login")
    public ResponseEntity<Login> updateLogin (@RequestBody LoginDTO loginDTO){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.save(loginDTO));
    }
    @PutMapping("/professor")
    public ResponseEntity<Professor> updateProfessor (@RequestBody ProfessorDTO professorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorDTO));
    }
    @PutMapping("/{id}/endereco")
    public ResponseEntity<Bibliotecario> adicionarEnderecoBibliotecario(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setEndereco(endereco);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/contato")
    public ResponseEntity<Bibliotecario> adicionarContatoBibliotecario(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setContato(contato);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/login")
    public ResponseEntity<Bibliotecario> adicionarloginBibliotecario(@PathVariable Long id, @RequestBody Login login) {
        Optional<Bibliotecario> optionalBibliotecario = Optional.ofNullable(bibliotecarioService.findById(id));
        if (optionalBibliotecario.isPresent()) {
            Bibliotecario bibliotecario = optionalBibliotecario.get();
            bibliotecario.setLogin(login);
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/aluno/{id}/endereco")
    public ResponseEntity<Aluno> adicionarenderecoAluno(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setEndereco(endereco);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/aluno/{id}/contato")
    public ResponseEntity<Aluno> adicionarcontatoAluno(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setContato(contato);
            contatoService.save(new ContatoDTO());
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/aluno/{id}/login")
    public ResponseEntity<Aluno> adicionarloginAluno(@PathVariable Long id, @RequestBody Login login) {
        Optional<Aluno> optionalAluno = Optional.ofNullable(alunoService.findById(id));
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setLogin(login);
            loginService.save(new LoginDTO());
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/biblioteca/{id}/livros")
    public ResponseEntity<Biblioteca> adicionarLivrosBiblioteca(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setLivros(livroService.findAll());
            bibliotecaService.save(new BibliotecaDTO());
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/biblioteca/{id}/alunos")
    public ResponseEntity<Biblioteca> adicionarAlunosBiblioteca(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setAlunos(alunoService.findAll());
            bibliotecaService.save(new BibliotecaDTO());
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/biblioteca/{id}/professor")
    public ResponseEntity<Biblioteca> adicionarProfessorBiblioteca(@PathVariable Long id) {
        Optional<Biblioteca> optionalBiblioteca = Optional.ofNullable(bibliotecaService.findById(id));
        if (optionalBiblioteca.isPresent()) {
            Biblioteca biblioteca = optionalBiblioteca.get();
            biblioteca.setProfessores(professorService.findAll());
            bibliotecaService.save(new BibliotecaDTO());
            return ResponseEntity.ok(biblioteca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/professor/{id}/endereco")
    public ResponseEntity<Professor> adicionarenderecoProfessor(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setEndereco(endereco);
            enderecoService.save(new EnderecoDTO());
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/professor/{id}/contato")
    public ResponseEntity<Professor> adicionarcontatoProfessor(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setContato(contato);
            contatoService.save(new ContatoDTO());
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/professor/{id}/login")
    public ResponseEntity<Professor> adicionarloginProfessor(@PathVariable Long id, @RequestBody Login login) {
        Optional<Professor> optionalProfessor = Optional.ofNullable(professorService.findById(id));
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setLogin(login);
            loginService.save(new LoginDTO());
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBibliotecario(@PathVariable("id") Long id) {
        bibliotecarioService.deleteBibliotecario(id);
    }
    @DeleteMapping("/aluno/{id}")
    public void deleteAluno(@PathVariable("id") Long id) {
        alunoService.deleteAluno(id);
    }
    @DeleteMapping("/contato/{id}")
    public void deleteContato(@PathVariable("id") Long id) {
        contatoService.deleteContato(id);
    }
    @DeleteMapping("/devolucao/{id}")
    public void deleteDevolucao(@PathVariable("id") Long id) {
        devolucaoService.deleteDevolucao(id);
    }
    @DeleteMapping("/emprestimo/{id}")
    public void deleteEmprestimo(@PathVariable("id") Long id) {
        emprestimoService.deleteEmprestimo(id);
    }
    @DeleteMapping("/endereco/{id}")
    public void deletarEndereco(@PathVariable("id") Long id) {
        enderecoService.deleteEndereco(id);
    }
    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable("id") Long id) {
        livroService.deleteLivro(id);
    }
    @DeleteMapping("/login/{id}")
    public void deleteLogin(@PathVariable("id") Long id) {
        loginService.deleteLogin(id);
    }
    @DeleteMapping("/professor/{id}")
    public void deleteProfessor(@PathVariable("id") Long id) {
        professorService.deleteProfessor(id);
    }
}
