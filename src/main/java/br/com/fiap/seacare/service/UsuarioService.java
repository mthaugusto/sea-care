package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.UsuarioRequest;
import br.com.fiap.seacare.dto.response.UsuarioResponse;
import br.com.fiap.seacare.entity.Usuario;
import br.com.fiap.seacare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse> {


    @Autowired
    private UsuarioRepository repo;


    @Override
    public Usuario toEntity(UsuarioRequest r) {
        return Usuario.builder().
                nomeUsuario(r.nomeUsuario()).
                nivelPermissao(r.nivelPermissao()).
                cpf(r.cpf()).
                cep(r.cep()).
                login(r.login()).
                email(r.email()).
                senha(r.senha()).
                telefone(r.telefone()).
                build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {
        return UsuarioResponse.builder().
                id(e.getId()).
                nomeUsuario(e.getNomeUsuario()).
                nivelPermissao(e.getNivelPermissao()).
                login(e.getLogin()).
                build();
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Usuario> findAll(Example<Usuario> example) {
        return repo.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario e) {
        return repo.save(e);
    }
}
