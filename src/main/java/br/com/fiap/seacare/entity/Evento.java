package br.com.fiap.seacare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_EVENTO")
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
    @SequenceGenerator(name = "SQ_EVENTO", sequenceName = "SQ_EVENTO", allocationSize = 1)
    @Column(name="ID_EVENTO")
    private Long id;

    @Column(name="NM_EVENTO")
    private String nomeEvento;

    @Column(name="DT_EVENTO")
    private Date dataEvento;

    @Column(name="TP_EVENTO")
    private String tipoEvento;

    @Column(name="DESCRICAO")
    private String descricaoEvento;

    @Column(name="FOTO")
    private String foto;

    @Column(name="LOCAL")
    private String local;

    @Column(name="NR_PARTICIPANTES")
    private Integer nrParticipantes;

    @Column(name="AVALIACAO")
    private Integer avaliacao;

    @Column(name="MEDIA_AVALIACOES")
    private Double mediaAvaliacoes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_EVENTO_PARCEIRO",
            joinColumns = {
                    @JoinColumn(
                            name = "ID_EVENTO",
                            referencedColumnName = "ID_EVENTO",
                            foreignKey = @ForeignKey(name = "FK_EVENTO_PARCEIRO_EVENTO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_PARCEIRO",
                            referencedColumnName = "ID_PARCEIRO",
                            foreignKey = @ForeignKey(name = "FK_EVENTO_PARCEIRO_PARCEIRO")
                    )
            }
    )
    private Set<Parceiro> parceiros = new LinkedHashSet<>();


}
