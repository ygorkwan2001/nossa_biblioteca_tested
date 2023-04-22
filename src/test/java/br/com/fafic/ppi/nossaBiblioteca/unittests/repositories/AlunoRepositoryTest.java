package br.com.fafic.ppi.nossaBiblioteca.unittests.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import br.com.fafic.ppi.nossaBiblioteca.repositories.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    void save() {
        Aluno aluno = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");

        Aluno savedAluno = alunoRepository.save(aluno);

        assertThat(savedAluno.getId()).isNotNull();
        assertThat(savedAluno.getNome()).isEqualTo(aluno.getNome());
        assertThat(savedAluno.getCpf()).isEqualTo(aluno.getCpf());
        assertThat(savedAluno.getMatricula()).isEqualTo(aluno.getMatricula());
        assertThat(savedAluno.getGenero()).isEqualTo(aluno.getGenero());
        assertThat(savedAluno.getEndereco()).isEqualTo(aluno.getEndereco());
        assertThat(savedAluno.getContato()).isEqualTo(aluno.getContato());
        assertThat(savedAluno.getLogin()).isEqualTo(aluno.getLogin());
        assertThat(savedAluno.getCurso()).isEqualTo(aluno.getCurso());
    }

    @Test
    void findAll() {
        Aluno aluno1 = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");
        entityManager.persist(aluno1);

        Aluno aluno2 = new Aluno("Maria", "17259492023", "20210002", GeneroEnum.FEMININO,
                new Endereco("Rua B", 456, "Bairro Y", "Cidade X", "RJ"),
                new Contato("maria@gmail.com", "987654321"),
                new Login("maria", "654321"),
                "Engenharia Civil");
        entityManager.persist(aluno2);

        List<Aluno> alunos = alunoRepository.findAll();

        assertThat(alunos.size()).isEqualTo(2);
        assertThat(alunos.get(0)).isEqualTo(aluno1);
        assertThat(alunos.get(1)).isEqualTo(aluno2);
    }

    @Test
    void findById() {
        Aluno aluno = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");
        entityManager.persist(aluno);

        Aluno foundAluno = alunoRepository.findById(aluno.getId()).orElse(null);

        assertThat(foundAluno).isNotNull();
        assertThat(foundAluno.getId()).isEqualTo(aluno.getId());
        assertThat(foundAluno.getNome()).isEqualTo(aluno.getNome());
        assertThat(foundAluno.getCpf()).isEqualTo(aluno.getCpf());
        assertThat(foundAluno.getMatricula()).isEqualTo(aluno.getMatricula());
        assertThat(foundAluno.getGenero()).isEqualTo(aluno.getGenero());
        assertThat(foundAluno.getEndereco()).isEqualTo(aluno.getEndereco());
        assertThat(foundAluno.getContato()).isEqualTo(aluno.getContato());
        assertThat(foundAluno.getLogin()).isEqualTo(aluno.getLogin());
        assertThat(foundAluno.getCurso()).isEqualTo(aluno.getCurso());
    }

    @Test
    void deleteById() {
        Aluno aluno = new Aluno("João", "78571455058", "20210001", GeneroEnum.MASCULINO,
                new Endereco("Rua A", 123, "Bairro X", "Cidade Y", "SP"),
                new Contato("joao@gmail.com", "123456789"),
                new Login("joao", "123456"),
                "Ciência da Computação");
        entityManager.persist(aluno);

        alunoRepository.deleteById(aluno.getId());

        assertThat(alunoRepository.findById(aluno.getId())).isEmpty();
    }
}