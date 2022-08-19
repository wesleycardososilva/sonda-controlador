package com.wesleycardososilva.sonda.espacial.controlador.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_planeta")
public class Planeta {

    @Id
    @SequenceGenerator(
            name = "planeta_sequence",
            sequenceName = "planeta_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "planeta_sequence"
    )
    private Long planetaID;
    private String nome;
    private int dimensaoX;
    private int dimensaoY;
//    private int posicaoPouso;
//    private int posicaoFinal;

    @OneToMany
    @JoinColumn(
            name = "planeta_ID",
            referencedColumnName = "planetaID"
    )
    private List<Sonda> sondas;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    @JoinColumn(
            name = "planeta_id",
            referencedColumnName = "planetaID"
    )
    private List<Regiao> regioes;
}
