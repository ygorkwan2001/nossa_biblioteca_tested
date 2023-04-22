package br.com.fafic.ppi.nossaBiblioteca.Exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class DefaultException {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String messagem;
    private String path;
}
