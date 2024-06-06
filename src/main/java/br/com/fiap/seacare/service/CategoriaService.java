package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.CategoriaRequest;
import br.com.fiap.seacare.dto.response.CategoriaResponse;
import br.com.fiap.seacare.entity.Categoria;
import br.com.fiap.seacare.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ServiceDTO<Categoria, CategoriaRequest, CategoriaResponse>{

    @Autowired
    private CategoriaRepository repo;

    @Override
    public Categoria toEntity(CategoriaRequest r) {

        return Categoria.builder().
                nomeCategoria(r.nomeCategoria()).
                build();

    }

    @Override
    public CategoriaResponse toResponse(Categoria e) {
        return CategoriaResponse.builder().
                id(e.getId()).
                nomeCategoria(e.getNomeCategoria()).
                build();
    }

    @Override
    public List<Categoria> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Categoria> findAll(Example<Categoria> example) {
        return repo.findAll(example);
    }

    @Override
    public Categoria findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria e) {
        return repo.save(e);
    }
}
