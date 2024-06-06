package br.com.fiap.seacare.dto.response;
import lombok.Builder;

@Builder
public record ProdutoResponse(
        Long id,
        String nomeProduto,
        Double valorProduto,
        String linkProduto,
        Long fornecedorId,
        Long categoriaId
) {
}
