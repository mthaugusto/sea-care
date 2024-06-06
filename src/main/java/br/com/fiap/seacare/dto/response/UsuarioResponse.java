package br.com.fiap.seacare.dto.response;
import lombok.Builder;

@Builder
public record UsuarioResponse(
        Long id,
        String nomeUsuario,
        Integer nivelPermissao,
        String login
) {
}
