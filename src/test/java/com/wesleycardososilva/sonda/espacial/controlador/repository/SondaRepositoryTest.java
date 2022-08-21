package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SondaRepositoryTest {

    @Autowired
    SondaRepository sondaRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void moveSonda(){

        Sonda sonda = Sonda.builder()
                .comandos("MMRMMRMRRML")
                .name("cristalShip")
                .posicaoX(3)
                .posicaoY(3)
                .posicaoPousoX(3)
                .posicaoPousoY(3)
                .direcao('E')
                .build();
//        mockMvc.perform(post("/api/sondas/move{forumId}/register", 42L)

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