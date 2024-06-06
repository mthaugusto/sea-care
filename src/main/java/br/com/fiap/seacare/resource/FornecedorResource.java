package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.FornecedorRequest;
import br.com.fiap.seacare.dto.response.FornecedorResponse;
import br.com.fiap.seacare.entity.Fornecedor;
import br.com.fiap.seacare.service.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorResponse>> findAll(
            @RequestParam(required = false) String nomeFornecedor
    ) {
        Fornecedor fornecedor = Fornecedor.builder()
                .nomeFornecedor(nomeFornecedor)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Fornecedor> example = Example.of(fornecedor, matcher);

        List<Fornecedor> encontrados = service.findAll(example);

        List<FornecedorResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> findById(@PathVariable Long id) {
        Fornecedor fornecedor = service.findById(id);
        FornecedorResponse response = service.toResponse(fornecedor);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<FornecedorResponse> save(@Valid @RequestBody FornecedorRequest request) {
        Fornecedor entity = service.toEntity(request);
        Fornecedor saved = service.save(entity);
        FornecedorResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
