package br.com.fafic.ppi.nossaBiblioteca.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String uf;


}
