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
@Table(name="TB_INSCRICAO")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INSCRICAO")
    @SequenceGenerator(sequenceName = "SQ_INSCRICAO", name = "SQ_INSCRICAO", allocationSize = 1)
    @Column(name="ID_INSCRICAO")
    private Long id;

    @Column(name="DT_INSCRICAO")
    private Date dataInscricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "EVENTO",
            referencedColumnName = "ID_EVENTO",
            foreignKey = @ForeignKey(name = "FK_EVENTO_INSCRICAO")

    )
    private Evento evento;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_VOLUNTARIO_INSCRICAO")
    )
    private Usuario usuario;
}
