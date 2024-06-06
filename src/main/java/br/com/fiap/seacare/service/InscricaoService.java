package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.InscricaoRequest;
import br.com.fiap.seacare.dto.response.InscricaoResponse;
import br.com.fiap.seacare.entity.Inscricao;
import br.com.fiap.seacare.repository.EventoRepository;
import br.com.fiap.seacare.repository.InscricaoRepository;
import br.com.fiap.seacare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService implements ServiceDTO<Inscricao, InscricaoRequest, InscricaoResponse> {

    @Autowired
    private InscricaoRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Inscricao toEntity(InscricaoRequest r) {

        return Inscricao.builder().
                dataInscricao(r.dataInscricao()).
                usuario(usuarioRepository.findById(r.usuarioId()).orElse(null)).
                evento(eventoRepository.findById(r.eventoId()).orElse(null)).
                build();
    }

    @Override
    public InscricaoResponse toResponse(Inscricao e) {
        return InscricaoResponse.builder()
                .id(e.getId())
                .dataInscricao(e.getDataInscricao())
                .usuarioId(e.getUsuario() != null ? e.getUsuario().getId() : null)
                .eventoId(e.getEvento() != null ? e.getEvento().getId() : null)
                .build();
    }

    @Override
    public List<Inscricao> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Inscricao> findAll(Example<Inscricao> example) {
        return repo.findAll(example);
    }

    @Override
    public Inscricao findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Inscricao save(Inscricao e) {
        return repo.save(e);
    }
}
