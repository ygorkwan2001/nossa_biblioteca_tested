package br.com.fafic.ppi.nossaBiblioteca.integtest.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class AlunoServiceIntegrationTest {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setUp() {
        alunoRepository.deleteAll();
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
        alunoDTO.setCurso("Engenharia de Software");

        Aluno result =
                alunoService.save
                        (alunoDTO);

        assertEquals(alunoDTO.getNome(), result.getNome());
        assertEquals(alunoDTO.getCpf(), result.getCpf());
        assertEquals(alunoDTO.getMatricula(), result.getMatricula());
        assertEquals(alunoDTO.getGenero(), result.getGenero());
        assertEquals(alunoDTO.getEndereco(), result.getEndereco());
        assertEquals(alunoDTO.getContato(), result.getContato());
        assertEquals(alunoDTO.getLogin(), result.getLogin());
        assertEquals(alunoDTO.getCurso(), result.getCurso());
    }

    @Test
    void findAll() {
        AlunoDTO alunoDTO1 = new AlunoDTO();
        alunoDTO1.setNome("João");
        alunoDTO1.setCpf("78571455058");
        alunoDTO1.setMatricula("20210001");
        alunoDTO1.setGenero(GeneroEnum.MASCULINO);
        alunoDTO1.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        alunoDTO1.setContato(new Contato("joao@gmail.com", "123456789"));
        alunoDTO1.setLogin(new Login("joao", "123456"));
        alunoDTO1.setCurso("Engenharia de Software");

        AlunoDTO alunoDTO2 = new AlunoDTO();
        alunoDTO2.setNome("Maria");
        alunoDTO2.setCpf("17259492023");
        alunoDTO2.setMatricula("20210002");
        alunoDTO2.setGenero(GeneroEnum.FEMININO);
        alunoDTO2.setEndereco(new Endereco("Rua B", 456, "Bairro Y", "Cidade X", "RJ"));
        alunoDTO2.setContato(new Contato("maria@gmail.com", "987654321"));
        alunoDTO2.setLogin(new Login("maria", "654321"));
        alunoDTO2.setCurso("Ciência da Computação");


        alunoService.save
                (alunoDTO1);

        alunoService.save
                (alunoDTO2);

        List<Aluno> result = alunoService.findAll();

        assertEquals(2, result.size());
        assertEquals(alunoDTO1.getNome(), result.get(0).getNome());
        assertEquals(alunoDTO2.getNome(), result.get(1).getNome());
    }

    @Test
    void findById() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João");
        alunoDTO.setCpf("78571455058");
        alunoDTO.setMatricula("20210001");
        alunoDTO.setGenero(GeneroEnum.MASCULINO);
        alunoDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        alunoDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        alunoDTO.setLogin(new Login("joao", "123456"));
        alunoDTO.setCurso("Engenharia de Software");

        Aluno savedAluno =
                alunoService.save
                        (alunoDTO);

        Aluno result = alunoService.findById(savedAluno.getId());

        assertEquals(savedAluno.getNome(), result.getNome());
        assertEquals(savedAluno.getCpf(), result.getCpf());
        assertEquals(savedAluno.getMatricula(), result.getMatricula());
        assertEquals(savedAluno.getGenero(), result.getGenero());
        assertEquals(savedAluno.getEndereco(), result.getEndereco());
        assertEquals(savedAluno.getContato(), result.getContato());
        assertEquals(savedAluno.getLogin(), result.getLogin());
        assertEquals(savedAluno.getCurso(), result.getCurso());
    }

    @Test
    void deleteAluno() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("João");
        alunoDTO.setCpf("78571455058");
        alunoDTO.setMatricula("20210001");
        alunoDTO.setGenero(GeneroEnum.MASCULINO);
        alunoDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        alunoDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        alunoDTO.setLogin(new Login("joao", "123456"));
        alunoDTO.setCurso("Engenharia de Software");

        Aluno savedAluno =
                alunoService.save
                        (alunoDTO);

        alunoService.deleteAluno(savedAluno.getId());

        List<Aluno> result = alunoService.findAll();

        assertEquals(0, result.size());
    }
}