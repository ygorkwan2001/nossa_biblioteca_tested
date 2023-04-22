package br.com.fafic.ppi.nossaBiblioteca.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
