package com.wesleycardososilva.sonda.espacial.controlador.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoDTO {

    private String nomeSonda;
    private String nomePlaneta;
    private String comando;
    private int posicaoAtual;
    private int posicaoFinal;
}
