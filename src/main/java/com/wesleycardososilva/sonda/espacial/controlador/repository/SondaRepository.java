package com.wesleycardososilva.sonda.espacial.controlador.repository;

import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Planeta;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Long> {

//    public ResponseBody pousaSonda(PousoDTO pousoDTO);
//    public Sonda findByName(String name);

//    Sonda update(Sonda sonda, Long id);

    Sonda save(Sonda sonda);
//    Sonda save(Sonda sonda, Long sondaId);
    public Sonda findByName(String nome);
}
