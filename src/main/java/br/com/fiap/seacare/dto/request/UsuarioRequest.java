package br.com.fiap.seacare.dto.request;

import jakarta.validation.constraints.*;

public record UsuarioRequest(

        @NotNull(message = "O nome do voluntário não pode estar em branco")
        @NotBlank(message = "O nome do voluntário não pode estar em branco")
        @Size(max = 100, message = "O nome do voluntário não pode exceder 100 caracteres")
        String nomeUsuario,

        @Min(value = 0, message = "O status do parceiro deve ser no mínimo 0")
        @Max(value = 1, message = "O status do parceiro deve ser no máximo 1")
        Integer nivelPermissao,

        String cpf,

        @NotBlank(message = "O login não pode estar em branco")
        @Size(max = 20, message = "O login não pode exceder 50 caracteres")
        String login,

        @NotBlank(message = "A senha não pode estar em branco")
        @Size(max = 20, message = "A senha não pode exceder 20 caracteres")
        String senha,

        @NotBlank(message = "O CEP não pode estar em branco")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido, deve seguir o padrão 99999-999")
        String cep,

        @NotBlank(message = "O e-mail não pode estar em branco")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "O telefone não pode estar em branco")
        String telefone
)
{
}
