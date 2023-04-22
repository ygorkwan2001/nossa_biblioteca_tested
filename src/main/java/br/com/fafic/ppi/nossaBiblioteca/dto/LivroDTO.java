package br.com.fafic.ppi.nossaBiblioteca.dto;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.enums.AreaEnum;
import lombok.Data;

@Data
public class LivroDTO {

    private String isbn;
    private String nome;
    private AreaEnum area;
    private Emprestimo emprestimo;


}
