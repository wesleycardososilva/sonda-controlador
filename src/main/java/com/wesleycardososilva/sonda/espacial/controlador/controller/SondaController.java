package com.wesleycardososilva.sonda.espacial.controlador.controller;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.service.SondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SondaController {

    @Autowired
    private SondaService sondaService;

    @PostMapping("/sondas")
    public Sonda saveSonda(@RequestBody Sonda sonda) {

        return sondaService.saveSonda(sonda);
    }
    @PostMapping("/pouso")
    public ResponseBody pousaSonda(@RequestBody PousoDTO pousoDTO) {

        return sondaService.pousaSonda(pousoDTO);
    }
    @PostMapping("/pouso")
    public Sonda movimentaSonda(@RequestBody ComandoDTO comandoDTO) {

        return sondaService.movimentaSonda(comandoDTO);
    }
}
