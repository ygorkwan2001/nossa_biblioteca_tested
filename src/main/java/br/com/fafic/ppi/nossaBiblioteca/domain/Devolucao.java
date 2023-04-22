package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Devolucao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Emprestimo emprestimo;
    private LocalDate dataDeDevolucao;

    public Devolucao(Emprestimo emprestimo, LocalDate dataDeDevolucao) {
        this.emprestimo = emprestimo;
        this.dataDeDevolucao = dataDeDevolucao;
    }
}
