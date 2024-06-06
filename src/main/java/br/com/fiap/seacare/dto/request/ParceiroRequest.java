package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.*;

import java.util.Date;

public record ParceiroRequest(
        @NotBlank(message = "O nome do parceiro não pode estar em branco")
        String nomeParceiro,

        @NotBlank(message = "O CNPJ do parceiro não pode estar em branco")
        @Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}", message = "Formato de CNPJ inválido")
        String cnpj,

        @NotBlank(message = "O telefone do parceiro não pode estar em branco")
        String telefone,

        @NotBlank(message = "O e-mail do parceiro não pode estar em branco")
        @Email(message = "E-mail inválido")
        String email,

        String setor,

        @NotNull(message = "O status do parceiro não pode estar em branco")
        @Min(value = 0, message = "O status do parceiro deve ser no mínimo 0")
        @Max(value = 1, message = "O status do parceiro deve ser no máximo 1")
        Integer status,

        @NotNull(message = "A data de início não pode estar em branco")
        Date dt_inicio,

        Date dt_fim
) {
}
