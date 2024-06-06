package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.ParceiroRequest;
import br.com.fiap.seacare.dto.response.ParceiroResponse;
import br.com.fiap.seacare.entity.Parceiro;
import br.com.fiap.seacare.service.ParceiroService;
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
@RequestMapping("/parceiros")
public class ParceiroResource {

    @Autowired
    private ParceiroService service;

    @GetMapping
    public ResponseEntity<List<ParceiroResponse>> findAll(
            @RequestParam(required = false) String nomeParceiro,
            @RequestParam(required = false) String setor,
            @RequestParam(required = false) Integer status) {

        Parceiro parceiro = Parceiro.builder()
                .nomeParceiro(nomeParceiro)
                .setor(setor)
                .status(status)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Parceiro> example = Example.of(parceiro, matcher);
        List<Parceiro> encontrados = service.findAll(example);

        List<ParceiroResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParceiroResponse> findById(@PathVariable Long id) {
        Parceiro parceiro = service.findById(id);
        ParceiroResponse response = service.toResponse(parceiro);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ParceiroResponse> save(@Valid @RequestBody ParceiroRequest request) {
        Parceiro entity = service.toEntity(request);
        Parceiro saved = service.save(entity);
        ParceiroResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
