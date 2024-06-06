package br.com.fiap.seacare.service;

import br.com.fiap.seacare.dto.request.ParceiroRequest;
import br.com.fiap.seacare.dto.response.ParceiroResponse;
import br.com.fiap.seacare.entity.Parceiro;
import br.com.fiap.seacare.repository.ParceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParceiroService implements ServiceDTO<Parceiro, ParceiroRequest, ParceiroResponse> {

    @Autowired
    private ParceiroRepository repo;


    @Override
    public Parceiro toEntity(ParceiroRequest r) {
        return Parceiro.builder().
                nomeParceiro(r.nomeParceiro()).
                cnpj(r.cnpj()).
                telefone(r.telefone()).
                email(r.email()).
                dt_inicio(r.dt_inicio()).
                dt_fim(r.dt_fim()).
                setor(r.setor()).
                status(r.status()).
                build();
    }

    @Override
    public ParceiroResponse toResponse(Parceiro e) {
        return ParceiroResponse.builder().
                id(e.getId()).
                nomeParceiro(e.getNomeParceiro()).
                cnpj(e.getCnpj()).
                telefone(e.getTelefone()).
                email(e.getEmail()).
                setor(e.getSetor()).
                status(e.getStatus()).
                build();
    }

    @Override
    public List<Parceiro> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Parceiro> findAll(Example<Parceiro> example) {
        return repo.findAll(example);
    }

    @Override
    public Parceiro findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Parceiro save(Parceiro e) {
        return repo.save(e);
    }
}
