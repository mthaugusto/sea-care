package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RelatoRequest(
        @NotBlank(message = "O nome do relato não pode estar em branco")
        String nomeRelato,

        @NotBlank(message = "A descrição do relato não pode estar em branco")
        String descricaoRelato,

        String linkFoto,

        @NotNull(message = "O ID do usuário não pode estar em branco")
        @Positive(message = "O ID do usuário deve ser um número positivo")
        Long usuarioId
) {
}
