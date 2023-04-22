package br.com.fafic.ppi.nossaBiblioteca.dto;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import lombok.Data;
import java.util.List;

@Data
public class BibliotecaDTO {

    private String nome;
    private Bibliotecario bibliotecario;
    private List<Livro> livros;
    private List<Aluno> alunos;
    private List<Professor> professores;


}
