package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class SondaServiceImplTest {
    @Parameterized.Parameter(value = 0)
    private String nomeSonda;
    @Parameterized.Parameter(value = 1)
    private String nomePlaneta;
    @Parameterized.Parameter(value = 2)
    private String comando;
    @Parameterized.Parameter(value = 3)
    private int posicaoAtual;
    @Parameterized.Parameter(value = 4)
    private int posicaoFinal;

    SondaServiceImpl sondaServiceImpl;

    static Sonda sonda = Sonda.builder()
            .comandos("MMRMMRMRRML")
            .name("YYZ")
            .posicaoX(5)
            .posicaoY(1)
            .posicaoPousoX(3)
            .posicaoPousoY(3)
            .direcao('E')
            .build();

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][] {
                { "YYZ","Saturno","MMRMMRMRRML","","",sonda},
//                { "YYZ","Saturno","MMRMMRMRRML","","" },
//                { "YYZ","Saturno","MMRMMRMRRML","","" },
//                { "YYZ","Saturno","MMRMMRMRRML","","" },
        });
    }
//    public void testCalculaMovimento(){
//        assertEquals(sonda,sondaServiceImpl.movimentaSonda(nomeSonda,nomePlaneta,
//                comando,posicaoAtual,posicaoFinal));
//    }
}