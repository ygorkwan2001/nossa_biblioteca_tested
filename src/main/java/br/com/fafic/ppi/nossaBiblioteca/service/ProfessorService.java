package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Bibliotecario;
import br.com.fafic.ppi.nossaBiblioteca.domain.Professor;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.ProfessorDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.BibliotecarioRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor save(ProfessorDTO professorDTO){
        var professor = new Professor(professorDTO.getNome(),
                professorDTO.getCpf(),
                professorDTO.getMatricula(),
                professorDTO.getGenero(),
                professorDTO.getEndereco(),
                professorDTO.getContato(),
                professorDTO.getLogin(),
                professorDTO.getCurso());
        return professorRepository.save(professor);
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteProfessor(Long id) {
        var professor = professorRepository.findById(id);
        if(professor.isPresent()){
            professorRepository.deleteById(id);
        }
        else {
            professor.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
