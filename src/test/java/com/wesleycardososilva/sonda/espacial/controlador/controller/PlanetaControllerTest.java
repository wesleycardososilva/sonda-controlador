package com.wesleycardososilva.sonda.espacial.controlador.controller;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.service.PlanetaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlanetaControllerTest.class)
class PlanetaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetaService planetaService;

    private Planeta planeta = new Planeta();


    @BeforeEach
    void setUp() {
        Regiao regiaoUmDois = Regiao.builder()
                .regiaoID(1L)
                .nomePlaneta("fff")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .regiaoID(2L)
                .nomePlaneta("fff")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        planeta =
                Planeta.builder()
                        .planetaID(1L)
                        .nome("fff")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
    }

    @Test
    void savePlaneta() throws Exception {
        Regiao regiaoUmDois = Regiao.builder()
                .regiaoID(1L)
                .nomePlaneta("fff")
                .posicaoX(1)
                .posicaoY(2)
                .build();
        Regiao regiaoDoisTres = Regiao.builder()
                .regiaoID(1L)
                .nomePlaneta("fff")
                .posicaoX(2)
                .posicaoY(3)
                .build();
        Planeta inputPlaneta =
                Planeta.builder()
                        .planetaID(1L)
                        .nome("fff")
                        .dimensaoX(5)
                        .dimensaoY(5)
                        .regioes(List.of(regiaoUmDois,regiaoDoisTres))
                        .build();
        Mockito.when(planetaService.savePlaneta(inputPlaneta)).thenReturn(inputPlaneta)
                .thenReturn(planeta);
        mockMvc.perform(post("/api/planetas/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\n" +
                                "  {\n" +
                                "    \"nome\":\"fff\",\n" +
                                "    \"dimensaoX\":\"5\",\n" +
                                "    \"dimensaoY\":\"5\"\n" +
                                "    \"regioes\":[\n" +
                                "        {\n" +
                                "            \"posicaoX\": 1,\n" +
                                "            \"posicaoY\": 2,\n" +
                                "            \"nomePlaneta\":\"fff\"  \n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"posicaoX\": 2,\n" +
                                "            \"posicaoY\": 3,\n" +
                                "            \"nomePlaneta\":\"fff\"  \n" +
                                "        }\n" +
                                "    ]\n" +
                                " }"

                        ))
                .andExpect(status().isOk());
    }
}