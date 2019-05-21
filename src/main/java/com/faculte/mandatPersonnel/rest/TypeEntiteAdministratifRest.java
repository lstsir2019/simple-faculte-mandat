/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.model.service.TypeEntiteAdministratifService;
import com.faculte.mandatPersonnel.rest.converter.TypeEntiteAdministratifConverter;
import com.faculte.mandatPersonnel.rest.vo.TypeEntiteAdministratifVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/typeEntiteAdministratif/typeEntiteAdministratifs")
public class TypeEntiteAdministratifRest {

    @Autowired
    private TypeEntiteAdministratifService typeEntiteAdministratifService;

    @GetMapping("/typeEntiteAdministratifAll/")
    public List<TypeEntiteAdministratifVo> findAllTypeEntiteAdministratif() {
        return new TypeEntiteAdministratifConverter().toVo(typeEntiteAdministratifService.findAll());
    }


    
    //------------------------------------Getter & Setter --------------------------------------//

    public TypeEntiteAdministratifService getTypeEntiteAdministratifService() {
        return typeEntiteAdministratifService;
    }

    public void setTypeEntiteAdministratifService(TypeEntiteAdministratifService typeEntiteAdministratifService) {
        this.typeEntiteAdministratifService = typeEntiteAdministratifService;
    }
  
    
    

    
}
