package br.com.fafic.ppi.nossaBiblioteca.domain.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException (String msg){
        super(msg);
    }
}
