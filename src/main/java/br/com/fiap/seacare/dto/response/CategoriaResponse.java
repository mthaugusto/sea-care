package br.com.fiap.seacare.dto.response;

import lombok.Builder;

@Builder
public record CategoriaResponse(
        Long id,
        String nomeCategoria
) {
}
