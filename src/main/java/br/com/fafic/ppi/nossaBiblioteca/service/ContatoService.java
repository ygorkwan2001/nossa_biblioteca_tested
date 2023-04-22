package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.ContatoDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ContatoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public Contato save(ContatoDTO contatoDTO){
        var contato = new Contato(contatoDTO.getEmail(),
                contatoDTO.getNumero());
        return contatoRepository.save(contato);
    }

    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    public Contato findById(Long id){
        return contatoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteContato(Long id) {
        var contato = contatoRepository.findById(id);
        if(contato.isPresent()){
            contatoRepository.deleteById(id);
        }
        else {
            contato.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
