package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface SondaService {

   public Sonda saveSonda(Sonda sonda);
   public ResponseBody pousaSonda(PousoDTO pousoDTO);
  public Sonda movimentaSonda(ComandoDTO comandoDTO);

  public Sonda findByName(String name);
  public List<Regiao> findByPlaneta(String nomePlaneta);

}
