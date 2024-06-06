package br.com.fiap.seacare.resource;

import br.com.fiap.seacare.dto.request.UsuarioRequest;
import br.com.fiap.seacare.dto.response.UsuarioResponse;
import br.com.fiap.seacare.entity.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll(
            @RequestParam(required = false) String nomeUsuario,
            @RequestParam(required = false) Integer nivelPermissao) {

        Usuario usuario = Usuario.builder()
                .nomeUsuario(nomeUsuario)
                .nivelPermissao(nivelPermissao)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Usuario> example = Example.of(usuario, matcher);
        List<Usuario> encontrados = service.findAll(example);

        List<UsuarioResponse> response = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        UsuarioResponse response = service.toResponse(usuario);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest request) {
        Usuario entity = service.toEntity(request);
        Usuario saved = service.save(entity);
        UsuarioResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
