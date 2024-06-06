package br.com.fiap.seacare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_FORNECEDOR")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FORNECEDOR")
    @SequenceGenerator(name = "SQ_FORNECEDOR", sequenceName = "SQ_FORNECEDOR", allocationSize = 1)
    @Column(name="ID_FORNECEDOR")
    private Long id;

    @Column(name="NM_FORNECEDOR")
    private String nomeFornecedor;

    @Column(name="CNPJ")
    private String cnpj;

    @Column(name="TELEFONE")
    private String telefone;

    @Column(name="SETOR")
    private String setor;

}
