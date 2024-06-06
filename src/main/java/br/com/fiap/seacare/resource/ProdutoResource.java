package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.ProdutoRequest;
import br.com.fiap.seacare.dto.response.ProdutoResponse;
import br.com.fiap.seacare.entity.Produto;
import br.com.fiap.seacare.service.CategoriaService;
import br.com.fiap.seacare.service.FornecedorService;
import br.com.fiap.seacare.service.ProdutoService;
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
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll(
            @RequestParam(required = false) String nomeProduto,
            @RequestParam(required = false) Long fornecedorId,
            @RequestParam(required = false) Long categoriaId) {

        Produto produto = Produto.builder()
                .nomeProduto(nomeProduto)
                .fornecedor(fornecedorId != null ? fornecedorService.findById(fornecedorId) : null)
                .categoria(categoriaId != null ? categoriaService.findById(categoriaId) : null)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Produto> example = Example.of(produto, matcher);
        List<Produto> encontrados = service.findAll(example);

        List<ProdutoResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        Produto produto = service.findById(id);
        ProdutoResponse response = service.toResponse(produto);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ProdutoResponse> save(@Valid @RequestBody ProdutoRequest request) {
        Produto entity = service.toEntity(request);
        Produto saved = service.save(entity);
        ProdutoResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
