package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public interface SondaService {

   public Sonda saveSonda(Sonda sonda);

    Sonda pousaSonda(PousoDTO pousoDTO);

    //   public ResponseBody pousaSonda(PousoDTO pousoDTO);
  public Sonda movimentaSonda(ComandoDTO comandoDTO);

  public Sonda findByName(String name);
  public List<Regiao> findByPlaneta(String nomePlaneta);
//    public Sonda fetchSondaByName(String name);

}
