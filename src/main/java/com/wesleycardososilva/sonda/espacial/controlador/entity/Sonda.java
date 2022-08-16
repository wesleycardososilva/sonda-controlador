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
@Table(name = "tbl_sonda")
public class Sonda {
    @Id
    @SequenceGenerator(
            name = "sonda_sequence",
            sequenceName = "sonda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sonda_sequence"
    )
    private Long sondaId;
    private char direcao;
    private String comandos;
    private int posicaoX;
    private int posicaoY;
    private int posicaoPousoX;
    private int posicaoPousoY;
    private String name;
}
