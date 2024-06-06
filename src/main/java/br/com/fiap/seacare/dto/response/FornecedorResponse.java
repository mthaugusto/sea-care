package br.com.fiap.seacare.dto.response;
import lombok.Builder;

@Builder
public record FornecedorResponse(
        Long id,
        String nomeFornecedor,
        String cnpj,
        String telefone,
        String setor
) {
}
