package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.BibliotecarioDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario save(BibliotecarioDTO bibliotecarioDTO){
        var bibliotecario = new Bibliotecario(bibliotecarioDTO.getNome(),
                bibliotecarioDTO.getCpf(),
                bibliotecarioDTO.getMatricula(),
                bibliotecarioDTO.getGenero(),
                bibliotecarioDTO.getEndereco(),
                bibliotecarioDTO.getContato(),
                bibliotecarioDTO.getLogin());
        return bibliotecarioRepository.save(bibliotecario);
    }

    public List<Bibliotecario> findAll(){
        return bibliotecarioRepository.findAll();
    }

    public Bibliotecario findById(Long id){
        return bibliotecarioRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteBibliotecario(Long id) {
        var bibliotecario = bibliotecarioRepository.findById(id);
        if(bibliotecario.isPresent()){
            bibliotecarioRepository.deleteById(id);
        }
        else {
            bibliotecario.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
