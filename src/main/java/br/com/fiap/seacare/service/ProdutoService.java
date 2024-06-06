package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.ProdutoRequest;
import br.com.fiap.seacare.dto.response.ProdutoResponse;
import br.com.fiap.seacare.entity.Produto;
import br.com.fiap.seacare.repository.CategoriaRepository;
import br.com.fiap.seacare.repository.FornecedorRepository;
import br.com.fiap.seacare.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse> {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Produto toEntity(ProdutoRequest r) {
        return Produto.builder().
                nomeProduto(r.nomeProduto()).
                valorProduto(r.valorProduto()).
                linkProduto(r.linkProduto()).
                fornecedor(fornecedorRepository.findById(r.fornecedorId()).orElse(null)).
                categoria(categoriaRepository.findById(r.categoriaId()).orElse(null)).
                build();
    }

    @Override
    public ProdutoResponse toResponse(Produto e) {
        return ProdutoResponse.builder().
                id(e.getId()).
                nomeProduto(e.getNomeProduto()).
                valorProduto(e.getValorProduto()).
                linkProduto(e.getLinkProduto()).
                fornecedorId(e.getFornecedor() != null ? e.getFornecedor().getId() : null).
                categoriaId(e.getCategoria() != null ? e.getCategoria().getId() : null).
                build();
    }

    @Override
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Produto> findAll(Example<Produto> example) {
        return repo.findAll(example);
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Produto save(Produto e) {
        return repo.save(e);
    }
}
