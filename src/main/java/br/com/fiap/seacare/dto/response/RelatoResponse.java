package br.com.fiap.seacare.dto.response;
import lombok.Builder;

@Builder
public record RelatoResponse(
        Long id,
        String nomeRelato,
        String descricaoRelato,
        String linkFoto,
        Long usuarioId
) {
}
