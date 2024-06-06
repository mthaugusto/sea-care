package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

public record EventoRequest(

        @NotBlank(message = "O nome do evento não pode estar em branco")
        String nomeEvento,

        @NotNull(message = "Insira uma data para o evento")
        Date dataEvento,

        @NotBlank(message = "O tipo do evento não pode estar em branco")
        String tipoEvento,

        @NotBlank(message = "A descrição do evento não pode estar em branco")
        String descricaoEvento,
        String foto,

        @NotBlank(message = "O local do evento não pode estar em branco")
        String local,

        @PositiveOrZero(message = "O número de participantes deve ser positivo")
        Integer nrParticipantes,

        @NotNull(message = "Insira uma avaliação para o evento")
        @Size(min = 1, max = 5, message = "A avaliação deve ser entre 1 e 5 estrelas")
        Integer avaliacao,

        Double mediaAvaliacoes,
        Set<Long> parceirosIds
) {
}
