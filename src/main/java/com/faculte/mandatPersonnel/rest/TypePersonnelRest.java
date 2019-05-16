/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.model.service.TypePersonnelService;
import com.faculte.mandatPersonnel.rest.converter.TypePersonnelConverter;
import com.faculte.mandatPersonnel.rest.vo.TypePersonnelVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/typePersonnel/typePersonnels")
public class TypePersonnelRest {

    @Autowired
    private TypePersonnelService typePersonnelService;

    @GetMapping("/typePersonnelAll/")
    public List<TypePersonnelVo> findAllTypePersonnel() {
        return new TypePersonnelConverter().toVo(typePersonnelService.findAll());
    }

    @GetMapping("/libelle/{libelle}/")
    public TypePersonnelVo findByLibelle(@PathVariable("libelle") String libelle) {
        return new TypePersonnelConverter().toVo(typePersonnelService.findByLibelle(libelle));
    }

    
    
    //------------------------------------Getter & Setter --------------------------------------//
    public TypePersonnelService getTypePersonnelService() {
        return typePersonnelService;
    }

    public void setTypePersonnelService(TypePersonnelService typePersonnelService) {
        this.typePersonnelService = typePersonnelService;
    }

    
}
