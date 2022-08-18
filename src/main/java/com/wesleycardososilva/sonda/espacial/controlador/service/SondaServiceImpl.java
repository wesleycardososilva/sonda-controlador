package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.repository.RegiaoRepository;
import com.wesleycardososilva.sonda.espacial.controlador.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ejb.EJB;
import java.util.List;

@Service
public class SondaServiceImpl implements SondaService{

    @Autowired
    private SondaRepository sondaRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

//    @EJB
//    private Sonda sonda;

    @Override
    public Sonda saveSonda(Sonda sonda) {
        return sondaRepository.save(sonda);
    }

//    @Override
//    public ResponseBody pousaSonda(PousoDTO pousoDTO) {
//        //verificar na tabela planeta se a regiao é diferente de nul
//        // verificar se a posição está entre as dimensões definidas no planeta
//
//        return pousaSonda(pousoDTO);
//    }
    @Override
    public Sonda movimentaSonda(ComandoDTO comandoDTO){
        // consulta no banco todos os registros em planeta, na coluna regiao, que são diferentes de null.
        // compara movimento por movimento com os registros retornados da consulta.
        // se a consulta não retornar resultado algum, calcula onde a sonda ficará e salva a posição em planeta.

        /* Método que encontra todas as regiões ocupadas do planeta que a sonda irá se movimentar*/
        List<Regiao> regioes =  regiaoRepository.findByNomePlaneta(comandoDTO.getNomePlaneta());
        Sonda sonda = new Sonda();
        sonda = sondaRepository.findByName(comandoDTO.getNomePlaneta());

        if(regioes.isEmpty()){
            char[] chars = comandoDTO.getComando().toCharArray();
            int len = chars.length;
            for (char ch : chars) {
                movimenta(ch, sonda);
                //Aqui será feito a chamada do método que calcula para onde a sonda vai andar até encontrar a posição final
                // depois de calculado,insere no banco na coluna regiao da tabela Planete
            }
        }else{
            //calcula quadrante por quadrante que será percorrido
            // caso tenha algum lugar que está ocupado, a sonda não se movimenta
            throw new RuntimeException("Comando nao pode ser executado.");
        }

        return sondaRepository.save(sonda);
    }

    @Override
    public Sonda findByName(String nome) {
        return sondaRepository.findByName(nome);
    }

    @Override
    public List<Regiao> findByPlaneta(String nomePlaneta) {
        return null;
    }
    public boolean isPresent(List<Regiao> regioes, int quadrante){

        Regiao elemento = regioes.stream()
                .filter(regiao ->quadrante == (regiao.getPosicao()))
                .findFirst()
                .orElse(null);
        if(elemento !=null){
            return true;
        }else return false;
    }


    public void movimenta(char ch, Sonda sonda){
        switch (ch) {
            case 'L':
                setDirecaoLeft(sonda);
                break;
            case 'R':
                setDirecaoRight(sonda);
                break;
            case 'M':
                setPosicao(sonda);
        }
    }

    public void setDirecaoLeft(Sonda sonda){
        switch (sonda.getDirecao()){
            case 'N':
                sonda.setDirecao('W');
                break;
            case 'W':
                sonda.setDirecao('S');
                break;
            case 'S':
                sonda.setDirecao('E');
                break;
            case 'E':
                sonda.setDirecao('N');
                break;
            default: throw new RuntimeException("Direção inválida");
        }
    }

    public void setDirecaoRight(Sonda sonda){
        switch (sonda.getDirecao()){
            case 'N':
                sonda.setDirecao('E');
                break;
            case 'W':
                sonda.setDirecao('N');
                break;
            case 'S':
                sonda.setDirecao('W');
                break;
            case 'E':
                sonda.setDirecao('S');
                break;
            default: throw new RuntimeException("Direção inválida");
        }
    }
    public void setPosicao(Sonda sonda){
        switch (sonda.getDirecao()){
            case 'N':
                sonda.setPosicaoY(sonda.getPosicaoY() +1 );
                break;
            case 'W':
                sonda.setPosicaoX(sonda.getPosicaoX() -1 );
                break;
            case 'S':
                sonda.setPosicaoY(sonda.getPosicaoY() -1 );
                break;
            case 'E':
                sonda.setPosicaoX(sonda.getPosicaoX() + 1 );
                break;
            default: throw new RuntimeException("Movimento inválida");
        }
    }

}
