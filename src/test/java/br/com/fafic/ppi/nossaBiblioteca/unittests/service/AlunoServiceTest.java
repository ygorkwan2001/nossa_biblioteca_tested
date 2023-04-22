package br.com.fafic.ppi.nossaBiblioteca.unittests.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.dto.AlunoDTO;
import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import br.com.fafic.ppi.nossaBiblioteca.repositories.AlunoRepository;
import br.com.fafic.ppi.nossaBiblioteca.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AlunoServiceTest {

    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        alunoService = new AlunoService(alunoRepository);
    }

    @Test
    void save() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João");
        alunoDTO.setCpf("78571455058");
        alunoDTO.setMatricula("20210001");
        alunoDTO.setGenero(GeneroEnum.MASCULINO);
        alunoDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        alunoDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        alunoDTO.setLogin(new Login("joao", "123456"));
        alunoDTO.setCurso("Ciência da Computação");

        Aluno aluno = new Aluno(alunoDTO.getNome(),
                alunoDTO.getCpf(),
                alunoDTO.getMatricula(),
                alunoDTO.getGenero(),
                alunoDTO.getEndereco(),
                alunoDTO.getContato(),
                alunoDTO.getLogin(),
                alunoDTO.getCurso());

        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.save(alunoDTO);

        assertEquals(aluno.getNome(), result.getNome());
        assertEquals(aluno.getCpf(), result.getCpf());
        assertEquals(aluno.getMatricula(), result.getMatricula());
        assertEquals(aluno.getGenero(), result.getGenero());
        assertEquals(aluno.getEndereco(), result.getEndereco());
        assertEquals(aluno.getContato(), result.getContato());
        assertEquals(aluno.getLogin(), result.getLogin());
        assertEquals(aluno.getCurso(), result.getCurso());
    }

    @Test
    void findAll() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação"));
        alunos.add(new Aluno("Maria", "17259492023", "20210002", GeneroEnum.FEMININO,
                new Endereco("Rua B", 456, "Bairro Y", "Cidade X", "RJ"),
                new Contato("maria@gmail.com", "987654321"),
                new Login("maria", "654321"),
                "Engenharia Civil"));

        when(alunoRepository.findAll()).thenReturn(alunos);

        List<Aluno> result = alunoService.findAll();

        assertEquals(alunos.size(), result.size());
        assertEquals(alunos.get(0).getNome(), result.get(0).getNome());
        assertEquals(alunos.get(1).getNome(), result.get(1).getNome());
    }

    @Test
    void findById() {
        Long id = 1L;
        Aluno aluno = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");

        when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));

        Aluno result = alunoService.findById(id);

        assertEquals(aluno.getNome(), result.getNome());
        assertEquals(aluno.getCpf(), result.getCpf());
        assertEquals(aluno.getMatricula(), result.getMatricula());
        assertEquals(aluno.getGenero(), result.getGenero());
        assertEquals(aluno.getEndereco(), result.getEndereco());
        assertEquals(aluno.getContato(), result.getContato());
        assertEquals(aluno.getLogin(), result.getLogin());
        assertEquals(aluno.getCurso(), result.getCurso());
    }

    @Test
    void deleteAluno() {
        Long id = 1L;
        Aluno aluno = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");

        when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));

        alunoService.deleteAluno(id);

        assertEquals(0, alunoRepository.count());
    }
}