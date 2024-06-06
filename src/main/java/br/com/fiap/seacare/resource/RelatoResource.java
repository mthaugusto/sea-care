package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.RelatoRequest;
import br.com.fiap.seacare.dto.response.RelatoResponse;
import br.com.fiap.seacare.entity.Relato;
import br.com.fiap.seacare.service.RelatoService;
import br.com.fiap.seacare.service.UsuarioService;
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
@RequestMapping("/relatos")
public class RelatoResource {

    @Autowired
    private RelatoService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<RelatoResponse>> findAll(
            @RequestParam(required = false) Long usuarioId)
    {

        Relato relato = Relato.builder()
                .usuario(usuarioId != null ? usuarioService.findById(usuarioId) : null)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Relato> example = Example.of(relato, matcher);
        List<Relato> encontrados = service.findAll(example);

        List<RelatoResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelatoResponse> findById(@PathVariable Long id) {
        Relato relato = service.findById(id);
        RelatoResponse response = service.toResponse(relato);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<RelatoResponse> save(@Valid @RequestBody RelatoRequest request) {
        Relato entity = service.toEntity(request);
        Relato saved = service.save(entity);
        RelatoResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
