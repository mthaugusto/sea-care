package br.com.fiap.seacare.dto.request;

public record ProdutoRequest(
        String nomeProduto,
        String valorProduto,
        String linkProduto,
        Long fornecedorId,
        Long categoriaId
) {
}
