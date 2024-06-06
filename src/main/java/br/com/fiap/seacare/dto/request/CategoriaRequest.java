package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank(message = "O nome da categoria não pode estar em branco!")
        String nomeCategoria
) {
}
