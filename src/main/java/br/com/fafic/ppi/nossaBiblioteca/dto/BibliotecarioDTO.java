package br.com.fafic.ppi.nossaBiblioteca.dto;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.enums.GeneroEnum;
import lombok.Data;

import java.util.List;

@Data
public class BibliotecarioDTO {

    private String nome;
    private String cpf;
    private String matricula;
    private GeneroEnum genero;
    private Endereco endereco;
    private Contato contato;
    private Login login;


}
