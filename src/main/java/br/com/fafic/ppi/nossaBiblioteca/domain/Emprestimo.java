package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorempretimo = 0.0;
    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;
    private LocalDate dataDoEmprestimo;
    @OneToOne(cascade = CascadeType.ALL)
    private Livro livro;

    public Emprestimo(Double valorempretimo, Aluno aluno, Professor professor, LocalDate dataDoEmprestimo, Livro livro) {
        this.valorempretimo = valorempretimo;
        this.aluno = aluno;
        this.professor = professor;
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.livro = livro;
    }
}
