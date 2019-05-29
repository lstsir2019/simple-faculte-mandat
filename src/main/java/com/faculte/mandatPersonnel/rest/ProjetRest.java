/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.example.produitv2.commun.GeneratePdf;
import com.faculte.mandatPersonnel.model.service.ProjetService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.rest.converter.ProjetConverter;
import com.faculte.mandatPersonnel.rest.vo.ProjetVo;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abdou
 */
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projet/projets")

public class ProjetRest {

    @Autowired
    private ProjetService projetService;
    
    @Autowired
    private SousProjetService sousProjetService;
    
    @GetMapping("/projetAll/")
    public List<ProjetVo> findAll() {
        return new ProjetConverter().toVo(projetService.findAll());
    }
    
    @GetMapping("/libelleProjet/{libelleP}")
    public ProjetVo findByLibelleP(@PathVariable("libelleP") String libelleP) {
        return new ProjetConverter().toVo(projetService.findByLibelleP(libelleP));
    }
    
    @PostMapping("/")
    public int creerProjet(@RequestBody ProjetVo projetVo) {
        return projetService.creerProjet(new ProjetConverter().toItem(projetVo));
    }
    
    @DeleteMapping("/deleteProjet/{libelleP}")
    public int deleteProjet(@PathVariable String libelleP) {
        return projetService.deleteByLibelleP(libelleP);
    }
    
    @GetMapping("/projet/{libelleP}/pdf")
    // @Produces("application/pdf")
    public ResponseEntity<Object> report(@PathVariable("libelleP") String libelleP) throws JRException, IOException {
        Map<String, Object> parameters = new HashMap<>();        
        parameters.put("libelleP", libelleP);
        return GeneratePdf.generate("projet", parameters, sousProjetService.findByProjetLibelleP(libelleP), "/report/projetPdf.jasper");
    }

//    @PostMapping("/sous/libelleP/{libelleP}")
//    public List<SousProjetVo> findByCriteria(@PathVariable("libelleP") String libelleP){
//        return new SousProjetConverter().toVo(sousProjetService.findByCriteria(libelleP));
//    }

    @PostMapping("/chercherProjet")
    public List<ProjetVo> chercherProjet(@RequestBody ProjetVo projetVo) {
        return new ProjetConverter().toVo(projetService.chercherProjet(projetVo.getLibelleP()));
    }
    
    
    //------------------------------------Getter & Setter-----------------------------------------//
    public ProjetService getProjetService() {
        return projetService;
    }

    public void setProjetService(ProjetService projetService) {
        this.projetService = projetService;
    }

    public SousProjetService getSousProjetService() {
        return sousProjetService;
    }

    public void setSousProjetService(SousProjetService sousProjetService) {
        this.sousProjetService = sousProjetService;
    }
    
    
}
