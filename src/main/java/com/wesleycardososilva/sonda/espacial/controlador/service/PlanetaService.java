package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface PlanetaService {
    public Planeta savePlaneta(Planeta planeta);
}
