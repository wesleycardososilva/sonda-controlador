package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    @InjectMocks
    SondaServiceImpl sondaServiceImpl = new SondaServiceImpl();
    @InjectMocks
    ComandoDTO comandoDto = new ComandoDTO();
    @InjectMocks
    PousoDTO pousoDTO = new PousoDTO();

//    @Parameterized.Parameters
//    public static Collection<Object[]> testConditions(){
//        return Arrays.asList(new Object[][] {
//                { "YYZ","Saturno","MMRMMRMRRML","","",sonda},
////                { "YYZ","Saturno","MMRMMRMRRML","","" },
////                { "YYZ","Saturno","MMRMMRMRRML","","" },
////                { "YYZ","Saturno","MMRMMRMRRML","","" },
//        });
//    }
//    public void testCalculaMovimento(){
//        assertEquals(sonda,sondaServiceImpl.movimentaSonda(nomeSonda,nomePlaneta,
//                comando,posicaoAtual,posicaoFinal));
//    }


    @Test
    public void testaMovimentaSonda(){
        Regiao regiaoUmDois = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta planeta =
                Planeta.builder()
                        .nome("fff")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        Sonda sonda = Sonda.builder()
                .sondaId(123123L)
                .comandos("MMRMMRMRRML")
                .name("fff")
                .posicaoX(3)
                .posicaoY(3)
                .posicaoPousoX(3)
                .posicaoPousoY(3)
                .direcao('E')
                .build();
        comandoDto.setNomeSonda("fff");
        comandoDto.setComando("MMRMMRMRRML");
        comandoDto.setNomePlaneta("fff");
        Sonda sondaResultado = new Sonda();
        Sonda sondaRetorno = new Sonda();
        sondaResultado.setPosicaoY(1);
        sondaResultado.setPosicaoX(5);
        sondaResultado.setDirecao('N');
        sondaRetorno= sondaServiceImpl.calculaMovimento(sonda, comandoDto);
        Assert.assertEquals(sondaResultado.getPosicaoX(),sondaRetorno.getPosicaoX() );
        Assert.assertEquals(sondaResultado.getPosicaoY(),sondaRetorno.getPosicaoY() );
        Assert.assertEquals(sondaResultado.getDirecao(),sondaRetorno.getDirecao() );
    }
    @Test
    public void testaMovimentaSonda_ForaDaRegiao(){
        Regiao regiaoUmDois = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta planeta =
                Planeta.builder()
                        .nome("fff")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        Sonda sonda = Sonda.builder()
                .sondaId(123123L)
                .comandos("MMRMMRMRRML")
                .name("fff")
                .posicaoX(5)
                .posicaoY(1)
                .posicaoPousoX(5)
                .posicaoPousoY(1)
                .direcao('N')
                .build();
        comandoDto.setNomeSonda("fff");
        comandoDto.setComando("MMRMMRMRRML");
        comandoDto.setNomePlaneta("fff");
        Sonda sondaResultado = new Sonda();
        Sonda sondaRetorno = new Sonda();
        sondaResultado.setPosicaoY(1);
        sondaResultado.setPosicaoX(5);
        sondaResultado.setDirecao('N');
        sondaRetorno= sondaServiceImpl.calculaMovimento(sonda, comandoDto);
        boolean foraDoPlaneta = sondaServiceImpl.foraDoPlaneta(sondaRetorno);
        Assert.assertEquals(foraDoPlaneta, true);
    }
    @Test
    public void testaPousoSonda(){
        Regiao regiaoUmDois = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .nomePlaneta("fff")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta planeta =
                Planeta.builder()
                        .nome("Marte")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        Sonda sonda = Sonda.builder()
                .sondaId(123123L)
                .comandos("MMRMMRMRRML")
                .name("fff")
                .posicaoX(3)
                .posicaoY(3)
                .posicaoPousoX(3)
                .posicaoPousoY(3)
                .direcao('E')
                .build();
        pousoDTO.setNomeSonda("fff");
        pousoDTO.setRegiaoPousoX(1);
        pousoDTO.setRegiaoPousoY(1);
        pousoDTO.setDirecao('N');
        pousoDTO.setNomePlaneta("fff");
        pousoDTO.setNomePlaneta("Marte");
        Sonda sondaResultado = new Sonda();
        Sonda sondaRetorno = new Sonda();
        sondaResultado.setPosicaoY(1);
        sondaResultado.setPosicaoX(1);
        sondaResultado.setDirecao('N');
        sondaRetorno= sondaServiceImpl.pousaSonda(pousoDTO);
        Assert.assertEquals(sondaResultado.getPosicaoPousoX(),sondaRetorno.getPosicaoPousoX() );
        Assert.assertEquals(sondaResultado.getPosicaoPousoY(),sondaRetorno.getPosicaoPousoY() );
        Assert.assertEquals(sondaResultado.getDirecao(),sondaRetorno.getDirecao() );
    }

}