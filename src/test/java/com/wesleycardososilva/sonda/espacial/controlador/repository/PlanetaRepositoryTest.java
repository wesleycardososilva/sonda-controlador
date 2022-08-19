package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetaRepositoryTest {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Test
    public void savePlaneta(){

        Regiao regiaoUmDois = Regiao.builder()
                .nomePlaneta("Saturno")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .nomePlaneta("Saturno")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta planeta =
                Planeta.builder()
                        .nome("Saturno")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        planetaRepository.save(planeta);
    }

}