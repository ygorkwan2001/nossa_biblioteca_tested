package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Aluno;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.AlunoDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno save(AlunoDTO alunoDTO){
        var aluno = new Aluno(alunoDTO.getNome(),
                alunoDTO.getCpf(),
                alunoDTO.getMatricula(),
                alunoDTO.getGenero(),
                alunoDTO.getEndereco(),
                alunoDTO.getContato(),
                alunoDTO.getLogin(),
                alunoDTO.getCurso());
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteAluno(Long id) {
        var aluno = alunoRepository.findById(id);
        if(aluno.isPresent()){
            alunoRepository.deleteById(id);
        }
        else {
            aluno.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
