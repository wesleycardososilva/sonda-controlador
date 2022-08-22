package com.wesleycardososilva.sonda.espacial.controlador.controller;

import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.service.SondaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SondaController.class)
class SondaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SondaService sondaService;

    private Sonda sonda;

    private PousoDTO pousoDTO = new PousoDTO();

    @BeforeEach
    void setUp() {
         sonda = Sonda.builder()
                .comandos("MMRMMRMRRML")
                .name("fff")
                .posicaoX(3)
                .posicaoY(3)
                .posicaoPousoX(3)
                .posicaoPousoY(3)
                .direcao('E')
                .build();
    }

    @Test
    void saveSonda() throws Exception {
        Sonda inputSonda = Sonda.builder()
                .comandos("MMRMMRMRRML")
                .name("fff")
                .posicaoX(0)
                .posicaoY(0)
                .posicaoPousoX(3)
                .posicaoPousoY(3)
                .direcao('E')
                .build();
        Mockito.when(sondaService.saveSonda(inputSonda)).thenReturn(inputSonda)
                .thenReturn(sonda);
        mockMvc.perform(post("/api/sondas/sonda")
                .contentType(MediaType.APPLICATION_JSON)
                .content("\t{\n" +
                                "    \"direcao\":\"E\",\n" +
                                "    \"comandos\":\"MMRMMRMRRML\",\n" +
                                "    \"posicaoX\":1,\n" +
                                "    \"posicaoY\":2,\n" +
                                "\t\"posicaoPousoX\":3,\n" +
                                "    \"posicaoPousoY\":3,\n" +
                                "\t\"name\":\"fff\"\n" +
                                " }"

                        ))
                .andExpect(status().isOk());
    }
    @Test
    void findByName() throws Exception {
        Mockito.when(sondaService.findByName("fff"))
                .thenReturn(sonda);

        mockMvc.perform(get("/api/sondas/name")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                                .value(sonda.getName()));

    }

    @Test
    void pousaSonda() throws Exception {
         pousoDTO.setNomePlaneta("zzz");
         pousoDTO.setRegiaoPousoY(0);
         pousoDTO.setRegiaoPousoX(0);
         pousoDTO.setDirecao('N');
         pousoDTO.setNomeSonda("MM");

        Mockito.when(sondaService.pousaSonda(pousoDTO))
                .thenReturn(sonda);
        mockMvc.perform(post("/api/sondas/pouso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\t{\n" +
                                "    \"direcao\":\"E\",\n" +
                                "    \"comandos\":\"MMRMMRMRRML\",\n" +
                                "    \"posicaoX\":1,\n" +
                                "    \"posicaoY\":2,\n" +
                                "\t\"posicaoPousoX\":3,\n" +
                                "    \"posicaoPousoY\":3,\n" +
                                "\t\"name\":\"fff\"\n" +
                                " }"

                        ))
                .andExpect(status().isOk());
    }
}