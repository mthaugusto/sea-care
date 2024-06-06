package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoriaRequest(
        @NotNull(message = "A categoria é obrigatória!")
        @NotBlank(message = "O nome da categoria não pode estar em branco!")
        String nomeCategoria
) {
}
