package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.EmprestimoDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.EmprestimoRepository;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private Livro livro;

    public Emprestimo save(EmprestimoDTO emprestimoDTO){
        var emprestimo = new Emprestimo(emprestimoDTO.getValoremprestimo(),
                emprestimoDTO.getAluno(),
                emprestimoDTO.getProfessor(),
                emprestimoDTO.getDataDoEmprestimo(),
                emprestimoDTO.getLivro());
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(Long id){
        return emprestimoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteEmprestimo(Long id) {
        var empretimo = emprestimoRepository.findById(id);
        if(empretimo.isPresent()){
            emprestimoRepository.deleteById(id);
        }
        else {
            empretimo.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
