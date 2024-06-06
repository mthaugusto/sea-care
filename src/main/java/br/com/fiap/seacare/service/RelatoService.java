package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.RelatoRequest;
import br.com.fiap.seacare.dto.response.RelatoResponse;
import br.com.fiap.seacare.entity.Relato;
import br.com.fiap.seacare.repository.RelatoRepository;
import br.com.fiap.seacare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoService implements ServiceDTO<Relato, RelatoRequest, RelatoResponse> {

    @Autowired
    private RelatoRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Relato toEntity(RelatoRequest r) {
        return Relato.builder().
                nomeRelato(r.nomeRelato()).
                descricaoRelato(r.descricaoRelato()).
                linkFoto(r.linkFoto()).
                usuario(usuarioRepository.findById(r.usuarioId()).orElse(null)).
                build();
    }

    @Override
    public RelatoResponse toResponse(Relato e) {
        return RelatoResponse.builder().
                id(e.getId()).
                nomeRelato(e.getNomeRelato()).
                descricaoRelato(e.getDescricaoRelato()).
                linkFoto(e.getLinkFoto()).
                usuarioId(e.getUsuario() != null ? e.getUsuario().getId() : null).
                build();
    }

    @Override
    public List<Relato> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Relato> findAll(Example<Relato> example) {
        return repo.findAll(example);
    }

    @Override
    public Relato findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Relato save(Relato e) {
        return repo.save(e);
    }
}
