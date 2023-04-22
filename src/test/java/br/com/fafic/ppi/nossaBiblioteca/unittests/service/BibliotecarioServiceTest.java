package br.com.fafic.ppi.nossaBiblioteca.unittests.service;

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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BibliotecarioServiceTest {

    private BibliotecarioService bibliotecarioService;

    @Mock
    private BibliotecarioRepository bibliotecarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bibliotecarioService = new BibliotecarioService(bibliotecarioRepository);
    }

    @Test
    void save() {
        BibliotecarioDTO bibliotecarioDTO = new BibliotecarioDTO();
        bibliotecarioDTO.setNome("João");
        bibliotecarioDTO.setCpf("78571455058");
        bibliotecarioDTO.setMatricula("20210001");
        bibliotecarioDTO.setGenero(GeneroEnum.MASCULINO);
        bibliotecarioDTO.setEndereco(new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"));
        bibliotecarioDTO.setContato(new Contato("joao@gmail.com", "123456789"));
        bibliotecarioDTO.setLogin(new Login("joao", "123456"));

        Bibliotecario bibliotecario = new Bibliotecario(bibliotecarioDTO.getNome(),
                bibliotecarioDTO.getCpf(),
                bibliotecarioDTO.getMatricula(),
                bibliotecarioDTO.getGenero(),
                bibliotecarioDTO.getEndereco(),
                bibliotecarioDTO.getContato(),
                bibliotecarioDTO.getLogin());

        when(bibliotecarioRepository.save(any(Bibliotecario.class))).thenReturn(bibliotecario);

        Bibliotecario result = bibliotecarioService.save(bibliotecarioDTO);

        assertEquals(bibliotecario.getNome(), result.getNome());
        assertEquals(bibliotecario.getCpf(), result.getCpf());
        assertEquals(bibliotecario.getMatricula(), result.getMatricula());
        assertEquals(bibliotecario.getGenero(), result.getGenero());
        assertEquals(bibliotecario.getEndereco(), result.getEndereco());
        assertEquals(bibliotecario.getContato(), result.getContato());
        assertEquals(bibliotecario.getLogin(), result.getLogin());
    }

    @Test
    void findAll() {
        List<Bibliotecario> bibliotecarios = new ArrayList<>();
        bibliotecarios.add(new Bibliotecario("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456")));
        bibliotecarios.add(new Bibliotecario("Maria", "17259492023", "20210002", GeneroEnum.FEMININO,
                new Endereco("Rua B", 456, "Bairro Y", "Cidade X", "RJ"),
                new Contato("maria@gmail.com", "987654321"),
                new Login("maria", "654321")));

        when(bibliotecarioRepository.findAll()).thenReturn(bibliotecarios);

        List<Bibliotecario> result = bibliotecarioService.findAll();

        assertEquals(bibliotecarios.size(), result.size());
        assertEquals(bibliotecarios.get(0).getNome(), result.get(0).getNome());
        assertEquals(bibliotecarios.get(1).getNome(), result.get(1).getNome());
    }

    @Test
    void findById() {
        Long id = 1L;
        Bibliotecario bibliotecario = new Bibliotecario("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"));

        when(bibliotecarioRepository.findById(id)).thenReturn(Optional.of(bibliotecario));

        Bibliotecario result = bibliotecarioService.findById(id);

        assertEquals(bibliotecario.getNome(), result.getNome());
        assertEquals(bibliotecario.getCpf(), result.getCpf());
        assertEquals(bibliotecario.getMatricula(), result.getMatricula());
        assertEquals(bibliotecario.getGenero(), result.getGenero());
        assertEquals(bibliotecario.getEndereco(), result.getEndereco());
        assertEquals(bibliotecario.getContato(), result.getContato());
        assertEquals(bibliotecario.getLogin(), result.getLogin());
    }

    @Test
    void deleteBibliotecario() {
        Long id = 1L;
        Bibliotecario bibliotecario = new Bibliotecario("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"));

        when(bibliotecarioRepository.findById(id)).thenReturn(Optional.of(bibliotecario));

        bibliotecarioService.deleteBibliotecario(id);

        assertEquals(0, bibliotecarioRepository.count());
    }
}