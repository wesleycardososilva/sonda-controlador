package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.repository.PlanetaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetaServiceImplTest {

    @Autowired
    private PlanetaService planetaService;

    @MockBean
    private PlanetaRepository planetaRepository;

    @BeforeEach
    void setUp() {
        Regiao regiaoUmDois = Regiao.builder()
                .regiaoID(123L)
                .nomePlaneta("qqq")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .regiaoID(1231L)
                .nomePlaneta("qqq")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta planeta =
                Planeta.builder()
                        .planetaID(123L)
                        .nome("qqq")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();

        Mockito.when(planetaRepository.findByNome("qqq")).thenReturn(planeta);
    }

    @Test
    @DisplayName("Encontra o dado baseado em nome de valido planeta")
    public void nomeValido_PlanetaEhEncontrado(){

        String nomePlaneta = "qqq";
        Planeta encontrado =
                planetaService.findByNome(nomePlaneta);

        assertEquals(nomePlaneta, encontrado.getNome());
    }

}