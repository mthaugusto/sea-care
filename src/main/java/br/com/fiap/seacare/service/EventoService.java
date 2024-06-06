package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.EventoRequest;
import br.com.fiap.seacare.dto.response.EventoResponse;
import br.com.fiap.seacare.entity.Evento;
import br.com.fiap.seacare.entity.Parceiro; // Importe a classe Parceiro
import br.com.fiap.seacare.repository.EventoRepository;
import br.com.fiap.seacare.repository.ParceiroRepository; // Importe o repositório de Parceiro
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService implements ServiceDTO<Evento, EventoRequest, EventoResponse> {

    @Autowired
    private EventoRepository repo;

    @Autowired
    private ParceiroRepository parceiroRepository; // Injete o repositório de Parceiro

    @Override
    public Evento toEntity(EventoRequest r) {
        return Evento.builder()
                .nomeEvento(r.nomeEvento())
                .dataEvento(r.dataEvento())
                .tipoEvento(r.tipoEvento())
                .descricaoEvento(r.descricaoEvento())
                .foto(r.foto())
                .local(r.local())
                .nrParticipantes(r.nrParticipantes())
                .avaliacao(r.avaliacao())
                .mediaAvaliacoes(r.mediaAvaliacoes())
                .parceiros(r.parceirosIds().stream().map(parceiroId -> parceiroRepository.findById(parceiroId).orElse(null)).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public EventoResponse toResponse(Evento e) {
        return EventoResponse.builder()
                .id(e.getId())
                .nomeEvento(e.getNomeEvento())
                .dataEvento(e.getDataEvento())
                .tipoEvento(e.getTipoEvento())
                .descricaoEvento(e.getDescricaoEvento())
                .foto(e.getFoto())
                .local(e.getLocal())
                .nrParticipantes(e.getNrParticipantes())
                .avaliacao(e.getAvaliacao())
                .mediaAvaliacoes(e.getMediaAvaliacoes())
                .parceirosId(e.getParceiros().stream().map(Parceiro::getId).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public List<Evento> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Evento> findAll(Example<Evento> example) {
        return repo.findAll(example);
    }

    @Override
    public Evento findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Evento save(Evento e) {
        return repo.save(e);
    }
}
