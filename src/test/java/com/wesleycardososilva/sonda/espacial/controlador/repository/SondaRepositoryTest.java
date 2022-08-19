package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SondaRepositoryTest {

    @Autowired
    SondaRepository sondaRepository;

    @Test
    public void moveSonda(){


//        Regiao regiaoUmDois = Regiao.builder()
//                .nomePlaneta("Saturno")
//                .posicao(12)
//                .build();
//        Regiao regiaoDoisTres = Regiao.builder()
//                .nomePlaneta("Saturno")
//                .posicao(23)
//                .build();
//        Planeta planeta =
//                Planeta.builder()
//                        .nome("Saturno")
//                        .dimensaoX(5)
//                        .dimensaoY(5)
//                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
//                        .build();
//        planetaRepository.save(planeta);
    }

}