package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Tipo")
@Data
@NoArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2)
    private String nome;
    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String matricula;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

    public Pessoa(String nome, String cpf, String matricula, GeneroEnum genero, Endereco endereco, Contato contato, Login login) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.genero = genero;
        this.endereco = endereco;
        this.contato = contato;
        this.login = login;
    }
}
