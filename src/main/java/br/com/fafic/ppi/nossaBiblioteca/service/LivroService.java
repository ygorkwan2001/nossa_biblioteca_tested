package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.LivroDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro save(LivroDTO livroDTO){
        var livro = new Livro(livroDTO.getIsbn(),
                livroDTO.getNome(),
                livroDTO.getArea(),
                livroDTO.getEmprestimo());
        return livroRepository.save(livro);
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById (Long id) {
        return livroRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteLivro(Long id) {
        var livro = livroRepository.findById(id);
        if(livro.isPresent()){
            livroRepository.deleteById(id);
        }
        else {
            livro.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }




}
