package br.com.webApi.controller;

import br.com.webApi.model.Usuario;
import br.com.webApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/users")
    public List<Usuario>getUsers(){
         return repository.findAll();
    }
    @GetMapping("/users/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUserName(username);
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
       repository.delebeById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @PutMapping()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }


}
