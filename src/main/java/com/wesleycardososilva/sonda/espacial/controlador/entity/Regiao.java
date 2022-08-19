package com.wesleycardososilva.sonda.espacial.controlador.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_regiao")
public class Regiao {
    @Id
    @SequenceGenerator(
            name = "regiao_sequence",
            sequenceName = "regiao_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "regiao_sequence"
    )
    private Long regiaoID;
    private int posicaoX;
    private int posicaoY;
    private String nomePlaneta;
}
