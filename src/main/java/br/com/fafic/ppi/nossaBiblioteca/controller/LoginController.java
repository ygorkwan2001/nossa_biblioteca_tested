package br.com.fafic.ppi.nossaBiblioteca.controller;

import br.com.fafic.ppi.nossaBiblioteca.domain.Livro;
import br.com.fafic.ppi.nossaBiblioteca.domain.Login;
import br.com.fafic.ppi.nossaBiblioteca.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private Validator validator;

    @GetMapping
    public List<Login> findAll(){
        return loginService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(loginService.findById(id));
    }
}
