package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.EventoRequest;
import br.com.fiap.seacare.dto.response.EventoResponse;
import br.com.fiap.seacare.entity.Evento;
import br.com.fiap.seacare.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

    @Autowired
    private EventoService service;

    @GetMapping
    public ResponseEntity<List<EventoResponse>> findAll(
            @RequestParam(required = false) String nomeEvento
    ) {
        Evento evento = Evento.builder()
                .nomeEvento(nomeEvento)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Evento> example = Example.of(evento, matcher);

        List<Evento> encontrados = service.findAll(example);

        List<EventoResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponse> findById(@PathVariable Long id) {
        Evento evento = service.findById(id);
        EventoResponse response = service.toResponse(evento);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<EventoResponse> save(@Valid @RequestBody EventoRequest request) {
        Evento entity = service.toEntity(request);
        Evento saved = service.save(entity);
        EventoResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
