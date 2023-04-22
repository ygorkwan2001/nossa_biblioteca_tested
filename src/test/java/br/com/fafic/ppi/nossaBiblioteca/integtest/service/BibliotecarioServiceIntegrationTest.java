package br.com.fafic.ppi.nossaBiblioteca.integtest.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.dto.BibliotecarioDTO;
import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import br.com.fafic.ppi.nossaBiblioteca.service.BibliotecarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class BibliotecarioServiceIntegrationTest {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    @BeforeEach
    void setUp() {
        bibliotecarioRepository.deleteAll();
    }

    @Test
    void save() {
        BibliotecarioDTO bibliotecarioDTO = new BibliotecarioDTO();
        bibliotecarioDTO.setNome("João");
        bibliotecarioDTO.setCpf("44078593003");
        bibliotecarioDTO.setMatricula("202200");
        bibliotecarioDTO.setGenero(GeneroEnum.MASCULINO);
        bibliotecarioDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        bibliotecarioDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        bibliotecarioDTO.setLogin(new Login("joao", "123456"));

        Bibliotecario result = bibliotecarioService.save(bibliotecarioDTO);

        assertEquals(bibliotecarioDTO.getNome(), result.getNome());
        assertEquals(bibliotecarioDTO.getCpf(), result.getCpf());
        assertEquals(bibliotecarioDTO.getMatricula(), result.getMatricula());
        assertEquals(bibliotecarioDTO.getGenero(), result.getGenero());
        assertEquals(bibliotecarioDTO.getEndereco(), result.getEndereco());
        assertEquals(bibliotecarioDTO.getContato(), result.getContato());
        assertEquals(bibliotecarioDTO.getLogin(), result.getLogin());
    }

    @Test
    void findAll() {
        BibliotecarioDTO bibliotecarioDTO1 = new BibliotecarioDTO();
        bibliotecarioDTO1.setNome("João");
        bibliotecarioDTO1.setCpf("44078593003");
        bibliotecarioDTO1.setMatricula("202200");
        bibliotecarioDTO1.setGenero(GeneroEnum.MASCULINO);
        bibliotecarioDTO1.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        bibliotecarioDTO1.setContato(new Contato("joao@gmail.com", "123456789"));
        bibliotecarioDTO1.setLogin(new Login("joao", "123456"));

        BibliotecarioDTO bibliotecarioDTO2 = new BibliotecarioDTO();
        bibliotecarioDTO2.setNome("Maria");
        bibliotecarioDTO2.setCpf("49430756060");
        bibliotecarioDTO2.setMatricula("202201");
        bibliotecarioDTO2.setGenero(GeneroEnum.FEMININO);
        bibliotecarioDTO2.setEndereco(new Endereco("Rua B", 456, "Bairro Y", "Cidade X", "RJ"));
        bibliotecarioDTO2.setContato(new Contato("maria@gmail.com", "987654321"));
        bibliotecarioDTO2.setLogin(new Login("maria", "654321"));

        bibliotecarioService.save(bibliotecarioDTO1);
        bibliotecarioService.save(bibliotecarioDTO2);

        List<Bibliotecario> result = bibliotecarioService.findAll();

        assertEquals(2, result.size());
        assertEquals(bibliotecarioDTO1.getNome(), result.get(0).getNome());
        assertEquals(bibliotecarioDTO2.getNome(), result.get(1).getNome());
    }

    @Test
    void findById() {
        BibliotecarioDTO bibliotecarioDTO = new BibliotecarioDTO();
        bibliotecarioDTO.setNome("João");
        bibliotecarioDTO.setCpf("44078593003");
        bibliotecarioDTO.setMatricula("202200");
        bibliotecarioDTO.setGenero(GeneroEnum.MASCULINO);
        bibliotecarioDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        bibliotecarioDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        bibliotecarioDTO.setLogin(new Login("joao", "123456"));

        Bibliotecario savedBibliotecario = bibliotecarioService.save(bibliotecarioDTO);

        Bibliotecario result = bibliotecarioService.findById(savedBibliotecario.getId());

        assertEquals(savedBibliotecario.getNome(), result.getNome());
        assertEquals(savedBibliotecario.getCpf(), result.getCpf());
        assertEquals(savedBibliotecario.getMatricula(), result.getMatricula());
        assertEquals(savedBibliotecario.getGenero(), result.getGenero());
        assertEquals(savedBibliotecario.getEndereco(), result.getEndereco());
        assertEquals(savedBibliotecario.getContato(), result.getContato());
        assertEquals(savedBibliotecario.getLogin(), result.getLogin());
    }

    @Test
    void deleteBibliotecario() {
        BibliotecarioDTO bibliotecarioDTO = new BibliotecarioDTO();
        bibliotecarioDTO.setNome("João");
        bibliotecarioDTO.setCpf("44078593003");
        bibliotecarioDTO.setMatricula("202200");
        bibliotecarioDTO.setGenero(GeneroEnum.MASCULINO);
        bibliotecarioDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        bibliotecarioDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        bibliotecarioDTO.setLogin(new Login("joao", "123456"));

        Bibliotecario savedBibliotecario = bibliotecarioService.save(bibliotecarioDTO);

        bibliotecarioService.deleteBibliotecario(savedBibliotecario.getId());

        List<Bibliotecario> result = bibliotecarioService.findAll();

        assertEquals(0, result.size());
    }
}