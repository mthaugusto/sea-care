package br.com.fiap.seacare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="TB_USUARIO")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(sequenceName = "SQ_USUARIO", name = "SQ_USUARIO", allocationSize = 1)
    @Column(name="ID_USUARIO")
    private Long id;

    @Column(name="NM_USUARIO")
    private String nomeUsuario;

    @Column(name="NL_PERMISSAO")
    private Integer nivelPermissao;

    @Column(name="CPF")
    private String cpf;

    @Column(name="LOGIN")
    private String login;

    @Column(name="SENHA")
    private String senha;

    @Column(name="CEP")
    private String cep;

    @Column(name="EMAIL")
    private String email;

    @Column(name="TELEFONE")
    private String telefone;
}
