package com.wesleycardososilva.sonda.espacial.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PousoDTO {

    private int regiaoPousoX;
    private int regiaoPousoY;
    private String nomeSonda;
    private String nomePlaneta;
    private char direcao;
}
