package br.com.fiap.seacare.dto.request;

public record RelatoRequest(
        String nomeRelato,
        String descricaoRelato,
        String linkFoto,
        Long usuarioId
) {
}
