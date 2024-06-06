package br.com.fiap.seacare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
    @SequenceGenerator(sequenceName = "SQ_CATEGORIA", name = "SQ_CATEGORIA", allocationSize = 1)
    @Column(name="ID_CATEGORIA")
    private Long id;

    @Column(name="NM_CATEGORIA")
    private String nomeCategoria;
}
