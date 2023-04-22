package br.com.fafic.ppi.nossaBiblioteca.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
}
