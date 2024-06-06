package br.com.fiap.seacare.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record InscricaoResponse(
    Long id,
    Date dataInscricao,
    Long eventoId,
    Long usuarioId
) {
}
