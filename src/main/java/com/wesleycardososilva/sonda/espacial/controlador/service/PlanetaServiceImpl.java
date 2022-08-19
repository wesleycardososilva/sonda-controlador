package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetaServiceImpl implements PlanetaService{

    @Autowired
    private PlanetaRepository planetaRepository;
    @Override
    public Planeta savePlaneta(Planeta planeta) {

        return planetaRepository.save(planeta);
    }

    @Override
    public Planeta findByNome(String nome) {
        return planetaRepository.findByNome(nome);
    }

    @Override
    public void saveOrUpdate(Planeta planeta, Long id) {
        planetaRepository.save(planeta);
    }
}
