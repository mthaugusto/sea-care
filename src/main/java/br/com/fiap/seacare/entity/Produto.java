package br.com.fiap.seacare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name="TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Column(name="ID_PRODUTO")
    private Long id;

    @Column(name="NM_PRODUTO")
    private String nomeProduto;

    @Column(name="VL_PRODUTO")
    private Double valorProduto;

    @Column(name="LINK")
    private String linkProduto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "FORNECEDOR",
            referencedColumnName = "ID_FORNECEDOR",
            foreignKey = @ForeignKey(name = "FK_FORNECEDOR_PRODUTO")
    )
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "CATEGORIA",
            referencedColumnName = "ID_CATEGORIA",
            foreignKey = @ForeignKey(name = "FK_CATEGORIA_PRODUTO")

    )
    private Categoria categoria;
}
