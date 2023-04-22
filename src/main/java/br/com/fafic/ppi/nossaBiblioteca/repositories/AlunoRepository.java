package br.com.fafic.ppi.nossaBiblioteca.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
