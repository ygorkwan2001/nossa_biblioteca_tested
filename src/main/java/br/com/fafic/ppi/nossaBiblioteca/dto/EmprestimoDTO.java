package br.com.fafic.ppi.nossaBiblioteca.dto;

import br.com.fafic.ppi.nossaBiblioteca.domain.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmprestimoDTO {

    private Double valoremprestimo;
    private Aluno aluno;
    private Professor professor;
    private LocalDate dataDoEmprestimo;
    private Livro livro;


}
