package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;

import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("Professor")
@Data
@NoArgsConstructor
public class Professor extends Pessoa{

    private String curso;

    public Professor(String nome, String cpf, String matricula, GeneroEnum genero, Endereco endereco, Contato contato, Login login, String curso) {
        super(nome, cpf, matricula, genero, endereco, contato, login);
        this.curso = curso;
    }
}
