package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record FornecedorRequest(

        @NotBlank(message = "O nome do parceiro não pode estar em branco")
        String nomeFornecedor,

        @NotBlank(message = "O CNPJ do parceiro não pode estar em branco")
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Formato de CNPJ inválido")
        String cnpj,

        String telefone,
        String setor
) {
}
