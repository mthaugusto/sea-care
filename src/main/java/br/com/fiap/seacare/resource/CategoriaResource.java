package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.CategoriaRequest;
import br.com.fiap.seacare.dto.response.CategoriaResponse;
import br.com.fiap.seacare.entity.Categoria;
import br.com.fiap.seacare.service.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll(
            @RequestParam(required = false) String nome
    ) {

        Categoria categoria = Categoria.builder().
                nomeCategoria(nome).
                build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Categoria> example = Example.of(categoria, matcher);

        List<Categoria> encontradas = service.findAll(example);

        List<CategoriaResponse> response = encontradas.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        Categoria categoria = service.findById(id);
        CategoriaResponse response = service.toResponse(categoria);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CategoriaResponse> save(@Valid @RequestBody CategoriaRequest request) {
        var entity = service.toEntity(request);
        var saved = service.save(entity);
        var response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
