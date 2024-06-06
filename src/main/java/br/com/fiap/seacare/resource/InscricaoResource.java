package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.InscricaoRequest;
import br.com.fiap.seacare.dto.response.InscricaoResponse;
import br.com.fiap.seacare.entity.Inscricao;
import br.com.fiap.seacare.service.EventoService;
import br.com.fiap.seacare.service.InscricaoService;
import br.com.fiap.seacare.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoResource {

    @Autowired
    private InscricaoService service;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<InscricaoResponse>> findAll(
            @RequestParam(required = false) Long eventoId,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) Date dataInscricao) {

        Inscricao inscricao = Inscricao.builder()
                .evento(eventoId != null ? eventoService.findById(eventoId) : null)
                .usuario(usuarioId != null ? usuarioService.findById(usuarioId) : null)
                .dataInscricao(dataInscricao)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Inscricao> example = Example.of(inscricao, matcher);
        List<Inscricao> encontradas = service.findAll(example);

        List<InscricaoResponse> response = encontradas.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoResponse> findById(@PathVariable Long id) {
        Inscricao inscricao = service.findById(id);
        InscricaoResponse response = service.toResponse(inscricao);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<InscricaoResponse> save(@Valid @RequestBody InscricaoRequest request) {
        Inscricao entity = service.toEntity(request);
        Inscricao saved = service.save(entity);
        InscricaoResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
