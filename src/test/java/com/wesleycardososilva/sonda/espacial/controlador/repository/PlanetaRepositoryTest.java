package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJdbcTest
class PlanetaRepositoryTest {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private  RegiaoRepository regiaoRepository;

    Planeta planeta = new Planeta();
    @BeforeEach
    void setUp() {
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
        planeta =
                Planeta.builder()
                        .nome("Saturno")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        entityManager.persist(planeta);

    }

    @Test
    public void findByNome_RetornaPlaneta(){

        Planeta planeta = planetaRepository.findByNome("Saturno");
        assertEquals(planeta.getNome(), "Saturno");
    }

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