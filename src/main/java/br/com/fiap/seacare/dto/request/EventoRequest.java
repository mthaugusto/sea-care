package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record EventoRequest(

        @NotNull(message = "Insira um nome para o evento")
        @NotBlank(message = "O nome do evento não pode estar em branco")
        String nomeEvento,

        @NotNull(message = "Insira uma data para o evento")
        Date dataEvento,

        @NotNull(message = "Insira um tipo para o evento")
        @NotBlank(message = "O tipo do evento não pode estar em branco")
        String tipoEvento,

        @NotNull(message = "Insira uma descrição para o evento")
        @NotBlank(message = "A descrição do evento não pode estar em branco")
        String descricaoEvento,
        String foto,

        @NotNull(message = "Insira um local para o evento")
        @NotBlank(message = "O local do evento não pode estar em branco")
        String local,
        Integer nrParticipantes,
        Integer avaliacao,
        Double mediaAvaliacoes,
        Set<Long> parceirosIds
) {
}
