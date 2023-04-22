package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Biblioteca;
import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.BibliotecaDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecaRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public Biblioteca save(BibliotecaDTO bibliotecaDTO){
        var biblioteca = new Biblioteca(bibliotecaDTO.getNome(),
                bibliotecaDTO.getBibliotecario(),
                bibliotecaDTO.getLivros(),
                bibliotecaDTO.getAlunos(),
                bibliotecaDTO.getProfessores());
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca findById(Long id){
        return bibliotecaRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteBiblioteca(Long id) {
        var biblioteca = bibliotecaRepository.findById(id);
        if(biblioteca.isPresent()){
            bibliotecaRepository.deleteById(id);
        }
        else {
            biblioteca.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
