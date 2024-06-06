package br.com.fiap.seacare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="TB_RELATO")
public class Relato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RELATO")
    @SequenceGenerator(name = "SQ_RELATO", sequenceName = "SQ_RELATO", allocationSize = 1)
    @Column(name="ID_RELATO")
    private Long id;

    @Column(name="NM_RELATO")
    private String nomeRelato;

    @Column(name="DESCRICAO")
    private String descricaoRelato;

    @Column(name="FOTO")
    private String linkFoto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_USUARIO_RELATO")

    )
    private Usuario usuario;
}
