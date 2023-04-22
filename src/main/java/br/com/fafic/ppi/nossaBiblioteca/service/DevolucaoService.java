package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Devolucao;
import br.com.fafic.ppi.nossaBiblioteca.domain.Emprestimo;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.DevolucaoDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.DevolucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DevolucaoService {

    private final DevolucaoRepository devolucaoRepository;
    private Emprestimo emprestimo;
    private EmprestimoService emprestimoService;


    public Devolucao save(DevolucaoDTO devolucaoDTO){
        var devolucao = new Devolucao(devolucaoDTO.getEmprestimo(),
                devolucaoDTO.getDataDeDevolucao());
        LocalDate dataempretimo = devolucaoDTO.getEmprestimo().getDataDoEmprestimo();
        LocalDate datadadevolucao = LocalDate.now();
        long days = dataempretimo.until(datadadevolucao, ChronoUnit.DAYS);
        if(days > 3){
            for(int i = 0; i <= days ; i++){
                Double valor = emprestimo.getValorempretimo() + 2;
            }
        }
        return devolucaoRepository.save(devolucao);
    }

    public List<Devolucao> findAll(){
        return devolucaoRepository.findAll();
    }

    public Devolucao findById(Long id){
        return devolucaoRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteDevolucao(Long id) {
        var devolucao = devolucaoRepository.findById(id);
        if(devolucao.isPresent()){
            devolucaoRepository.deleteById(id);
        }
        else {
            devolucao.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
