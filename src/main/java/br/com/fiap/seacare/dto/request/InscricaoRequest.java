package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record InscricaoRequest (
        @NotNull(message = "A data da inscrição não pode estar em branco")
        Date dataInscricao,

        @NotNull(message = "O ID do evento não pode estar em branco")
        Long eventoId,

        @NotNull(message = "O ID do voluntário não pode estar em branco")
        Long usuarioId
) {
}
