/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import com.faculte.mandatPersonnel.rest.converter.ResponsabiliteConverter;
import com.faculte.mandatPersonnel.rest.vo.ResponsabiliteVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/responsabilite/responsabilites")
public class ResponsabiliteRest {

    @Autowired
    private ResponsabiliteService responsabiliteService;

    @GetMapping("/responsabiliteAll/")
    public List<ResponsabiliteVo> findAllResponsabilite() {
        return new ResponsabiliteConverter().toVo(responsabiliteService.findAll());
    }

    @GetMapping("/responsabilite/{referenceResponsabilite}")
    public ResponsabiliteVo findByReferenceResponsabilite(@PathVariable("referenceResponsabilite") String referenceResponsabilite) {
        return new ResponsabiliteConverter().toVo(responsabiliteService.findByReferenceResponsabilite(referenceResponsabilite));
    }

    @PostMapping("/")
    public int creerResponsabilite(@RequestBody ResponsabiliteVo responsabiliteVo) {
        return responsabiliteService.creerResopnsabilite(new ResponsabiliteConverter().toItem(responsabiliteVo));
    }

    @DeleteMapping("/deleteResponsabilite/{referenceResponsabilite}")
    public int deleteByPoste(@PathVariable String referenceResponsabilite) {
        return responsabiliteService.deleteByReferenceResponsabilite(referenceResponsabilite);
    }
    
    @PutMapping("/updateResponsabilite")
    public int updateResponsabilite(@RequestBody ResponsabiliteVo responsabiliteVo) {
        return responsabiliteService.updateResponsabilite(new ResponsabiliteConverter().toItem(responsabiliteVo));
    }

    //------------------------------Getter & Setter-----------------------------------------//
    public ResponsabiliteService getResponsabiliteService() {
        return responsabiliteService;
    }

    public void setResponsabiliteService(ResponsabiliteService responsabiliteService) {
        this.responsabiliteService = responsabiliteService;
    }

    
    
}
