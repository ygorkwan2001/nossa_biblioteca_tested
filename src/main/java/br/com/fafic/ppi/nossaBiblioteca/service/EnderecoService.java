package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Contato;
import br.com.fafic.ppi.nossaBiblioteca.domain.Endereco;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.EnderecoDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ContatoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco save(EnderecoDTO enderecoDTO){
        var endereco = new Endereco(enderecoDTO.getRua(),
                enderecoDTO.getNumero(),
                enderecoDTO.getBairro(),
                enderecoDTO.getCidade(),
                enderecoDTO.getUf());
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }

    public void updateEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }
    public void deleteEndereco(Long id) {
        var endereco = enderecoRepository.findById(id);
        if(endereco.isPresent()){
            enderecoRepository.deleteById(id);
        }
        else {
            endereco.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
