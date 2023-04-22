package br.com.fafic.ppi.nossaBiblioteca.service;

import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import br.com.fafic.ppi.nossaBiblioteca.dto.LivroDTO;
import br.com.fafic.ppi.nossaBiblioteca.dto.LoginDTO;
import br.com.fafic.ppi.nossaBiblioteca.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public Login save(LoginDTO loginDTO){
        var login = new Login(loginDTO.getUsuario(),
                loginDTO.getSenha());
        return loginRepository.save(login);
    }

    public List<Login> findAll(){
        return loginRepository.findAll();
    }

    public Login findById(Long id){
        return loginRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = " + id));
    }
    public void deleteLogin(Long id) {
        var login = loginRepository.findById(id);
        if(login.isPresent()){
            loginRepository.deleteById(id);
        }
        else {
            login.orElseThrow(()-> new ObjectNotFoundException("Não existe na base de dados o Id = "+ id));
        }
    }
}
