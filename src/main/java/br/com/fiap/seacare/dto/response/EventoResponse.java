package br.com.fiap.seacare.dto.response;
import lombok.Builder;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
public record EventoResponse(
        Long id,
        String nomeEvento,
        Date dataEvento,
        String tipoEvento,
        String descricaoEvento,
        String foto,
        String local,
        Integer nrParticipantes,
        Integer avaliacao,
        Double mediaAvaliacoes,
        Set<Long> parceirosId
) {
}
