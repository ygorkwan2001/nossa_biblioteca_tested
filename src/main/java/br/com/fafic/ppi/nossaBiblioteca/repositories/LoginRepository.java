package br.com.fafic.ppi.nossaBiblioteca.repositories;

import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
