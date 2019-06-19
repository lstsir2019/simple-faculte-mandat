/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.example.produitv2.commun.GeneratePdf;
import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.rest.converter.EntiteAdministratifConverter;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/entiteAdministratif/entiteAdministratifs")
public class EntiteAdministratifRest {
     
    @Autowired
    private EntiteAdministratifService entiteAdministratifService;
    
     
    @GetMapping("/entiteAdministratifAll/")
    public List<EntiteAdministratifVo> findAllEntite() {
        return new EntiteAdministratifConverter().toVo(entiteAdministratifService.findAll());
    }
    
    @GetMapping("/referenceEntiteAdministratif/{referenceEntiteAdministratif}")
    public EntiteAdministratifVo findByReferenceEntiteAdministratif(@PathVariable("referenceEntiteAdministratif") String referenceEntiteAdministratif) {
        return new EntiteAdministratifConverter().toVo(entiteAdministratifService.findByReferenceEntiteAdministratif(referenceEntiteAdministratif));
    }
    
    @PostMapping("/")
    public int createEntiteAdministratif(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
        return entiteAdministratifService.createEntiteAdministratif(new EntiteAdministratifConverter().toItem(entiteAdministratifVo));
    }
    
    @DeleteMapping("/deleteEntiteAdministratif/{referenceEntiteAdministratif}")
    public int deleteEntite(@PathVariable String referenceEntiteAdministratif) {
        return entiteAdministratifService.deleteEntite(referenceEntiteAdministratif);
    }
    
 @PutMapping("/updateEntiteAdmin")
    public int updateEntite(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
        return entiteAdministratifService.updateEntite(new EntiteAdministratifConverter().toItem(entiteAdministratifVo));
    }

    
    @PostMapping("/chercherEntite")
    public List<EntiteAdministratifVo> chercherEntiteAdmin(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
        return new EntiteAdministratifConverter().toVo(entiteAdministratifService.chercherEntiteAdmin(entiteAdministratifVo.getReferenceEntiteAdministratif(),entiteAdministratifVo.getTypeEntiteAdministratifVo().getLibelle(),entiteAdministratifVo.getSousProjetVo().getReferenceSousProjet()));
    }
     @GetMapping("/entite/{referenceEntiteAdministratif}/pdf")
    // @Produces("application/pdf")
    public ResponseEntity<Object> report(@PathVariable("referenceEntiteAdministratif") String referenceEntiteAdministratif) throws JRException, IOException {
         Map<String, Object> parameters = new HashMap<>();
        //parameters.put("cin", cin);
        EntiteAdministratif  entite = entiteAdministratifService.findByReferenceEntiteAdministratif(referenceEntiteAdministratif);
        List<EntiteAdministratif> e = new ArrayList<>();
        e.add(entite);
        return GeneratePdf.generate("entite", parameters, e, "/report/entitePdf.jasper");
    }

    
    //----------------------------------Getter & Setter----------------------------------------------//

    
    
    public EntiteAdministratifService getEntiteAdministratifService() {
        return entiteAdministratifService;
    }

    public void setEntiteAdministratifService(EntiteAdministratifService entiteAdministratifService) {
        this.entiteAdministratifService = entiteAdministratifService;
    }





}



