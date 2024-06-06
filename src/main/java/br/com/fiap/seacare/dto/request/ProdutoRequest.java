package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoRequest(
        @NotBlank(message = "O nome do produto não pode estar em branco")
        String nomeProduto,

        @NotBlank(message = "O valor do produto não pode estar em branco")
        String valorProduto,

        @NotBlank(message = "O link do produto não pode estar em branco")
        String linkProduto,

        @NotNull(message = "O ID do fornecedor não pode estar em branco")
        @Positive(message = "O ID do fornecedor deve ser um número positivo")
        Long fornecedorId,

        @NotNull(message = "O ID da categoria não pode estar em branco")
        @Positive(message = "O ID da categoria deve ser um número positivo")
        Long categoriaId
) {
}
