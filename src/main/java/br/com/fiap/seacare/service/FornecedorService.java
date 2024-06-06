package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.FornecedorRequest;
import br.com.fiap.seacare.dto.response.FornecedorResponse;
import br.com.fiap.seacare.entity.Fornecedor;
import br.com.fiap.seacare.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService implements ServiceDTO<Fornecedor, FornecedorRequest, FornecedorResponse>{

    @Autowired
    private FornecedorRepository repo;

    @Override
    public Fornecedor toEntity(FornecedorRequest r) {
        return Fornecedor.builder().
                nomeFornecedor(r.nomeFornecedor()).
                cnpj(r.cnpj()).
                telefone(r.telefone()).
                setor(r.setor()).
                build();
    }

    @Override
    public FornecedorResponse toResponse(Fornecedor e) {
        return FornecedorResponse.builder().
                id(e.getId()).
                nomeFornecedor(e.getNomeFornecedor()).
                cnpj(e.getCnpj()).
                telefone(e.getTelefone()).
                setor(e.getSetor()).
                build();
    }

    @Override
    public List<Fornecedor> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Fornecedor> findAll(Example<Fornecedor> example) {
        return repo.findAll(example);
    }

    @Override
    public Fornecedor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Fornecedor save(Fornecedor e) {
        return repo.save(e);
    }
}
