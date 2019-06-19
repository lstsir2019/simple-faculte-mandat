/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.example.produitv2.commun.GeneratePdf;
import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.model.service.MandatService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.rest.converter.MandatConverter;
import com.faculte.mandatPersonnel.rest.vo.MandatVo;
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
    
    @PostMapping("/chercherMandat")
    public List<MandatVo> chercherMandat(@RequestBody MandatVo mandatVo) {
        return new MandatConverter().toVo(mandatService.chercherMandat(mandatVo.getPersonnelVo().getCin(), mandatVo.getEntiteAdministratifVo().getReferenceEntiteAdministratif(), mandatVo.getResponsabiliteVo().getReferenceResponsabilite()));
    }
    
    @PostMapping("/")
    public int creerMandat(@RequestBody MandatVo mandatVo) {
        return mandatService.creerMandat(new MandatConverter().toItem(mandatVo));
        
    }
    
    @DeleteMapping("/deleteMandat/{cin}")
    public int deleteMandat(@PathVariable String cin) {
        return mandatService.deleteByMandatPersonnelCin(cin);
    }


     @GetMapping("/mandatPersonnel/{cin}/pdf")
    // @Produces("application/pdf")
    public ResponseEntity<Object> report(@PathVariable("cin") String cin) throws JRException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        Mandat mandat = mandatService.findByPersonnelCin(cin);
//        parameters.put("cin", mandat.getPersonnel().getCin());
//        parameters.put("referenceEntiteAdministratif",mandat.getEntiteAdministratif().getReferenceEntiteAdministratif());
//        parameters.put("referenceResponsabilite", mandat.getResponsabilite().getReferenceResponsabilite());
        List<Mandat> m = new ArrayList<>();
        m.add(mandat);
        return GeneratePdf.generate("mandat", parameters, m, "/report/mandatPdf.jasper");
    }

    
     @PutMapping("/updateMandat")
    public int updateMandat(@RequestBody MandatVo mandatVo) {
        return mandatService.updateMandat(new MandatConverter().toItem(mandatVo));
    }
    //-------------------------------------------------GETTER & SETTER---------------------------------------------------//
    
    
    public MandatService getMandatService() {
        return mandatService;
    }
    
    public void setMandatService(MandatService mandatService) {
        this.mandatService = mandatService;
    }
    
}
