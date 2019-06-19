package com.faculte.mandatPersonnel.rest.proxy;

import com.faculte.mandatPersonnel.rest.vo.exchange.EchelleVo;
import com.faculte.mandatPersonnel.rest.vo.exchange.EchelonVo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abdou
 */
@FeignClient(name ="sample-faculte-evolution", url="localhost:8015")
public interface EvolutionProxy {
    
    @GetMapping("/evolution/echelle/reference/{reference}")
    public EchelleVo findEchelleByReference(@PathVariable("reference") String reference);
    
    @GetMapping("/evolution/echelon/reference/{reference}")
    public List<EchelonVo> findEchelonsByReference(@PathVariable("reference") String reference);
}
