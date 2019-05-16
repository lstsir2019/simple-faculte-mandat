/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.rest.converter.SousProjetConverter;
import com.faculte.mandatPersonnel.rest.vo.SousProjetVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sousProjet/sousProjets")
public class SousProjetRest {
  
    @Autowired
    private SousProjetService sousProjetService;  
    
    @GetMapping("/sousProjetAll/")
    public List<SousProjetVo> findAllSousProjet() {
        return new SousProjetConverter().toVo(sousProjetService.findAll());
    }
    
    @GetMapping("/sousProjet/{referenceSousProjet}")
    public SousProjetVo findByReferenceSousProjet(@PathVariable("referenceSousProjet") String referenceSousProjet) {
        return new SousProjetConverter().toVo(sousProjetService.findByReferenceSousProjet(referenceSousProjet));
    }
    
    @GetMapping("/libelleProjet/{libelleP}/sous-projet")
    public List<SousProjetVo> findByProjetLibelleP(@PathVariable("libelleP") String libelleP) {
        final List<SousProjet> sousProjets = sousProjetService.findByProjetLibelleP(libelleP);
        return new SousProjetConverter().toVo(sousProjets);
    }

//    @DeleteMapping("/deleteSp/{referenceSousProjet}")
//    public int deleteSousProjet(@PathVariable String referenceSousProjet) {
//        return sousProjetService.deleteByReferenceSousProjet(referenceSousProjet);
//    }
    @DeleteMapping("/deleteSousProjetById/{id}")
    public int deleteSousProjetById(@PathVariable("id") Long id) {
        return sousProjetService.deleteSousProjetById(id);
    }

}
