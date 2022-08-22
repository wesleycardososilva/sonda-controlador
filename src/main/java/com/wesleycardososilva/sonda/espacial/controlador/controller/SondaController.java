package com.wesleycardososilva.sonda.espacial.controlador.controller;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.service.SondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="api/sondas")
public class SondaController {

    @Autowired
    private SondaService sondaService;

    @PostMapping("/sonda")
    public Sonda saveSonda(@RequestBody Sonda sonda) {

        return sondaService.saveSonda(sonda);
    }
    @PostMapping("/pouso")
    public Sonda pousaSonda(@RequestBody PousoDTO pousoDTO) {

        return sondaService.pousaSonda(pousoDTO);
    }
    @PostMapping(value="/move")
    public Sonda movimentaSonda(@RequestBody ComandoDTO comandoDTO) {

        return sondaService.movimentaSonda(comandoDTO);
    }

    @GetMapping("sonda/{name}")
    public Sonda findByName(@PathVariable("name") String nomeSonda){
        return sondaService.findByName(nomeSonda);
    }
}
