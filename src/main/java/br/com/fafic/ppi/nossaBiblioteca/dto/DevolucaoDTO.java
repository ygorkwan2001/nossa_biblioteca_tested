package br.com.fafic.ppi.nossaBiblioteca.dto;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DevolucaoDTO {

    private Emprestimo emprestimo;
    private LocalDate dataDeDevolucao;


}
