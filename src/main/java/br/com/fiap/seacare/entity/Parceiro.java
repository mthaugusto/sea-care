package br.com.fiap.seacare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TB_PARCEIROS")
@Entity
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PARCEIROS")
    @SequenceGenerator(name = "SQ_PARCEIROS", sequenceName = "SQ_PARCEIROS", allocationSize = 1)
    @Column(name="ID_PARCEIRO")
    private Long id;

    @Column(name="NM_PARCEIRO")
    private String nomeParceiro;

    @Column(name="CNPJ")
    private String cnpj;

    @Column(name="TELEFONE")
    private String telefone;

    @Column(name="SETOR")
    private String setor;

    @Column(name="EMAIL")
    private String email;

    @Column(name="STATUS")
    private Integer status;

    @Column(name="DT_INICIO")
    private Date dt_inicio;

    @Column(name="DT_FIM")
    private Date dt_fim;

}
