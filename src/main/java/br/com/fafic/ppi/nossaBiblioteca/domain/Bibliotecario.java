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
@DiscriminatorValue("Bibliotecario")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Bibliotecario extends Pessoa{

    public Bibliotecario(String nome, String cpf, String matricula, GeneroEnum genero, Endereco endereco, Contato contato, Login login) {
        super(nome, cpf, matricula, genero, endereco, contato, login);
    }
}
