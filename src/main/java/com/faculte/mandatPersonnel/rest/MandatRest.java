/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.model.service.MandatService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.rest.converter.MandatConverter;
import com.faculte.mandatPersonnel.rest.vo.MandatVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/mandat/mandats")

public class MandatRest {
    
    @Autowired
    private SousProjetService sousProjetService;
    

    @Autowired
    private MandatService mandatService;
    

    @GetMapping("/mandatAll/")
    public List<MandatVo> findAllMandat() {
        return new MandatConverter().toVo(mandatService.findAll());
    }
    
    @GetMapping("/mandat/personnel/{cin}")
    public MandatVo findByMandatPersonnelCin(@PathVariable("cin") String cin) {
        return new MandatConverter().toVo(mandatService.findByPersonnelCin(cin));
    }

    @GetMapping("/entite/{referenceEntiteAdministratif}")
    public List<MandatVo> findByMandatEntiteAdministratifReferenceEntiteAdministratif(@PathVariable("referenceEntiteAdministratif") String referenceEntiteAdministratif) {
        return new MandatConverter().toVo(mandatService.findByEntiteAdministratifReferenceEntiteAdministratif(referenceEntiteAdministratif));
    }

    @GetMapping("/responsabilite/{referenceResponsabilite}")
    public List<MandatVo> findByMandatResponsabiliteReferenceResponsabilite(@PathVariable("referenceResponsabilite") String referenceResponsabilite) {
        return new MandatConverter().toVo(mandatService.findByResponsabiliteReferenceResponsabilite(referenceResponsabilite));
    }
    
    @PostMapping("/chercher/personnel/{cin}/entite/{referenceEntiteAdministratif}/responsabilite/{referenceResponsabilite}")
    public List<MandatVo> findByCriteria(@PathVariable("cin") String cin, @PathVariable("referenceResponsabilite") String referenceResponsabilite, @PathVariable("referenceEntiteAdministratif") String referenceEntiteAdministratif) {
        return new MandatConverter().toVo(mandatService.findByCriteria(cin, referenceEntiteAdministratif, referenceResponsabilite));
    }
    
    @PostMapping("/")
    public int creerMandat(@RequestBody MandatVo mandatVo) {
        return mandatService.creerMandat(new MandatConverter().toItem(mandatVo));
        
    }
    
    @DeleteMapping("/deleteMandat/{cin}")
    public int deleteMandat(@PathVariable String cin) {
        return mandatService.deleteByMandatPersonnelCin(cin);
    }


    //-------------------------------------------------GETTER & SETTER---------------------------------------------------//
    
    
    public MandatService getMandatService() {
        return mandatService;
    }
    
    public void setMandatService(MandatService mandatService) {
        this.mandatService = mandatService;
    }
    
}
