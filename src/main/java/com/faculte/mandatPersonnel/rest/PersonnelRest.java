/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.example.produitv2.commun.GeneratePdf;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.rest.converter.PersonnelConverter;
import com.faculte.mandatPersonnel.rest.proxy.EvolutionProxy;
import com.faculte.mandatPersonnel.rest.vo.PersonnelVo;
import com.faculte.mandatPersonnel.rest.vo.exchange.EchelleVo;
import com.faculte.mandatPersonnel.rest.vo.exchange.EchelonVo;
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
@RequestMapping("/personnel/personnels")
public class PersonnelRest {

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private EvolutionProxy evolutionProxy;

    @GetMapping("/personnelAll/")
    public List<PersonnelVo> findAllPersonnel() {
        return new PersonnelConverter().toVo(personnelService.findAll());
    }

    @GetMapping("/cin/{cin}")
    public PersonnelVo findByCin(@PathVariable("cin") String cin) {
        return new PersonnelConverter().toVo(personnelService.findByCin(cin));
    }
//    @GetMapping("/personnelCin/{cin}")
//    public List<PersonnelVo> findByPersonnelCin(@PathVariable("cin") String cin) {
//        return new PersonnelConverter().toVo(personnelService.findByCin(cin));
//    }

//    @PostMapping("/")
//    public PersonnelVo creerPersonnel(@RequestBody PersonnelVo personnelVo) {
//        PersonnelConverter personnelConverter = new PersonnelConverter();
//        Personnel p = personnelConverter.toItem(personnelVo);
//        Personnel personnel = personnelService.creerPersonnel(p);
//        return new PersonnelConverter().toVo(personnel);
//    }
    @PostMapping("/")
    public int creerPersonnel(@RequestBody PersonnelVo personnelVo) {
        return personnelService.creerPersonnel(new PersonnelConverter().toItem(personnelVo));
    }

    @DeleteMapping("/deletePersonnel/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return personnelService.deleteByCin(cin);
    }

    @PutMapping("/updatePersonnel")
    public int updatePersonnel(@RequestBody PersonnelVo personnelVo) {
        System.out.println(" ha l personnel =====>" + personnelVo.getNom());
        return personnelService.updatePersonnel(new PersonnelConverter().toItem(personnelVo));
    }

    @GetMapping("/findPersonnel/typePersonnel/{libelle}")
    public PersonnelVo findByTypePersonnelLibelle(@PathVariable("libelle") String libelle) {
        return new PersonnelConverter().toVo(personnelService.findByTypePersonnelLibelle(libelle));
    }

    @GetMapping("/referenceEchelle/{reference}")
    public EchelleVo findEchelleByReference(@PathVariable("reference") String reference) {
        return evolutionProxy.findEchelleByReference(reference);
    }

    @GetMapping("/referenceEchelon/{reference}")
    public List<EchelonVo> findEchelonsByReference(@PathVariable("reference") String reference) {
        return evolutionProxy.findEchelonsByReference(reference);
    }

    @GetMapping("/personnel/{cin}/pdf")
    // @Produces("application/pdf")
    public ResponseEntity<Object> report(@PathVariable("cin") String cin) throws JRException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        //parameters.put("cin", cin);
        Personnel personnel = personnelService.findByCin(cin);
        List<Personnel> p = new ArrayList<>();
        p.add(personnel);
        return GeneratePdf.generate("personnel", parameters, p, "/report/personnelPdf.jasper");
    }

    @PostMapping("/chercherPersonnel")
    public List<PersonnelVo> chercherPersonnel(@RequestBody PersonnelVo personnelVo) {
        return new PersonnelConverter().toVo(personnelService.chercherPersonnel(personnelVo.getCin(),personnelVo.getTypePersonnelVo().getLibelle()));
    }

    //---------------------------------------Getter & Setter--------------------------------------//
    public PersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public EvolutionProxy getEvolutionProxy() {
        return evolutionProxy;
    }

    public void setEvolutionProxy(EvolutionProxy evolutionProxy) {
        this.evolutionProxy = evolutionProxy;
    }

}
