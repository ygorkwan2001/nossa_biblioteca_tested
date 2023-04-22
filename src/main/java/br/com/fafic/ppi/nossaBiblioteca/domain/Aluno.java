package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;

import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("Aluno")
@NoArgsConstructor
public class Aluno extends Pessoa{

    private String curso;

    public Aluno(String nome, String cpf, String matricula, GeneroEnum genero, Endereco endereco, Contato contato, Login login, String curso) {
        super(nome, cpf, matricula, genero, endereco, contato, login);
        this.curso = curso;
    }
}
