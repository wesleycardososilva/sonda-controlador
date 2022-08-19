package com.wesleycardososilva.sonda.espacial.controlador.service;

import com.wesleycardososilva.sonda.espacial.controlador.dto.ComandoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.dto.PousoDTO;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Regiao;
import com.wesleycardososilva.sonda.espacial.controlador.entity.Sonda;
import com.wesleycardososilva.sonda.espacial.controlador.repository.PlanetaRepository;
import com.wesleycardososilva.sonda.espacial.controlador.repository.RegiaoRepository;
import com.wesleycardososilva.sonda.espacial.controlador.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SondaServiceImpl implements SondaService{

    @Autowired
    private SondaRepository sondaRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    PlanetaRepository planetaRepository;

    @Override
    public Sonda saveSonda(Sonda sonda) {
        return sondaRepository.save(sonda);
    }

    @Override
    public Sonda pousaSonda(PousoDTO pousoDTO) {
        List<Regiao> regioes =  regiaoRepository.findByNomePlaneta(pousoDTO.getNomePlaneta());
        Optional<Regiao> regiao =  regioes.stream().filter(o -> o.getNomePlaneta().equals(pousoDTO.getNomePlaneta())).findFirst();

        if(!isPresent(regioes,pousoDTO.getRegiaoPousoX(), pousoDTO.getRegiaoPousoX())){
            Sonda sonda = new Sonda();
            sonda.setPosicaoPousoX(pousoDTO.getRegiaoPousoX());
            sonda.setPosicaoPousoY(pousoDTO.getRegiaoPousoY());
            sonda.setDirecao(pousoDTO.getDirecao());
            sonda.setName(pousoDTO.getNomeSonda());
            Regiao quadrante = new Regiao();
            quadrante.setNomePlaneta(pousoDTO.getNomePlaneta());
            quadrante.setPosicaoX(pousoDTO.getRegiaoPousoX());
            quadrante.setPosicaoY(pousoDTO.getRegiaoPousoY());
            regiaoRepository.save(quadrante);
            return sondaRepository.save(sonda);
        }

        return pousaSonda(pousoDTO);
    }
    @Override
    public Sonda movimentaSonda(ComandoDTO comandoDTO){


        List<Regiao> regioes =  regiaoRepository.findByNomePlaneta(comandoDTO.getNomePlaneta());
        Optional<Regiao> regiao =  regioes.stream().filter(o -> o.getNomePlaneta().equals(comandoDTO.getNomePlaneta())).findFirst();

        Sonda sonda = new Sonda();
        sonda = sondaRepository.findByName(comandoDTO.getNomeSonda());
        sonda.setPosicaoX(sonda.getPosicaoPousoX());
        sonda.setPosicaoY(sonda.getPosicaoPousoY());

        sonda = calculaMovimento(sonda, comandoDTO);
        if(!dentroDoPlaneta(sonda)){
            sonda.setPosicaoX(sonda.getPosicaoPousoX());
            sonda.setPosicaoY(sonda.getPosicaoPousoY());
            return null;
        }

        if(!isPresent(regioes,sonda.getPosicaoX(), sonda.getPosicaoY())){
        sonda.setPosicaoPousoX(sonda.getPosicaoX());
        sonda.setPosicaoPousoY(sonda.getPosicaoY());
        Regiao quadrante = new Regiao();
        quadrante.setNomePlaneta(comandoDTO.getNomePlaneta());
        quadrante.setPosicaoX(sonda.getPosicaoX());
        quadrante.setPosicaoY(sonda.getPosicaoY());
        regiaoRepository.save(quadrante);
        return sondaRepository.save(sonda);
        }
        return null;
    }

    @Override
    public Sonda findByName(String nome) {
        return sondaRepository.findByName(nome);
    }

    @Override
    public List<Regiao> findByPlaneta(String nomePlaneta) {
        return null;
    }

    public boolean isPresent(List<Regiao> regioes, int coordenadaX, int coordenadaY){

        Regiao elemento = regioes.stream()
                .filter(regiao ->(coordenadaX == regiao.getPosicaoX() && coordenadaY == (regiao.getPosicaoY())))
                .findFirst()
                .orElse(null);
        if(elemento !=null){
            return true;
        }else return false;
    }
    public boolean dentroDoPlaneta(Sonda sonda){
        if(sonda.getPosicaoX() > 5 && sonda.getPosicaoY() > 5){
            return false;
        } else if (sonda.getPosicaoX() < 0 && sonda.getPosicaoY() < 0) {
            return false;
        }else return true;
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
    public Sonda calculaMovimento(Sonda sonda, ComandoDTO comandoDTO){
        char[] chars = comandoDTO.getComando().toCharArray();
        int len = chars.length;
        for (char ch : chars) {
            movimenta(ch, sonda);
        }
        return sonda;
    }

}
