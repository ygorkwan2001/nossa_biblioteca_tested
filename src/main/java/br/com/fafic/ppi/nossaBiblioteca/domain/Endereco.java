package br.com.fafic.ppi.nossaBiblioteca.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O campo rua nao pode estar em branco!!")
    private String rua;
    private Integer numero;
    @NotBlank(message = "O campo bairro nao pode estar em branco!!")
    private String bairro;
    @NotBlank(message = "O campo cidade nao pode estar em branco!!")
    private String cidade;
    @Size(max = 2,message = "numero maximo de caracteres é 2")
    @NotBlank(message = "O campo uf nao pode estar em branco!!")
    private String uf;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
}
