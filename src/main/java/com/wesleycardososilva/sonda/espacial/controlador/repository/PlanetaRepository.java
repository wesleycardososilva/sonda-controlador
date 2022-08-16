package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
}
