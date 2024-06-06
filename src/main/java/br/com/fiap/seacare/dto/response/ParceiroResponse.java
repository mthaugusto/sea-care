package br.com.fiap.seacare.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record ParceiroResponse(
        Long id,
        String nomeParceiro,
        String cnpj,
        String telefone,
        String email,
        String setor,
        Integer status

) {
}
