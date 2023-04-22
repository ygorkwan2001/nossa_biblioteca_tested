package br.com.fafic.ppi.nossaBiblioteca.enums;

public enum GeneroEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String status;

    GeneroEnum(String status){
        this.status = status;
    }
}
