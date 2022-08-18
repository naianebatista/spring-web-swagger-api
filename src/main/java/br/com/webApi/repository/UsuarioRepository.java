package br.com.webApi.repository;

import br.com.webApi.handler.BusinessException;
import br.com.webApi.handler.CampoObrigatorioException;
import br.com.webApi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//é fake
@Repository
public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getLogin()==null) {
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getPassword()==null){
            throw new CampoObrigatorioException("password");
        }

        if(usuario.getId()==null)   //se eu nao receber getId= save
            System.out.println("SAVE - recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void delebeById(Integer id){
        System.out.println(String.format("DELETE- recebendo o id : %d do usuário na camada de repositório",id));
        System.out.println(id);

    }
    public List<Usuario>findAll(){
        System.out.println("LIST- Listando os  users do system");
        List<Usuario> usuarios=new ArrayList<>();
        usuarios.add(new Usuario("heloisa","123"));
        usuarios.add(new Usuario("jean","321"));
        return usuarios;
    }
    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - recebendo o id : %d do usuário na camada de repositório",id));
        return new Usuario("heloisa","123");
    }
    public Usuario findByUserName(String username){
        System.out.println(String.format("FIND/username - recebendo o username do usuário na camada de repositório",username));
        return new Usuario("heloisa","123");
    }

}
