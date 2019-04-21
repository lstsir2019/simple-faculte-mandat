/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.model.service.ProjetService;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.model.service.MandatService;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.model.service.TypePersonnelService;
import com.faculte.mandatPersonnel.rest.converter.EntiteAdministratifConverter;
import com.faculte.mandatPersonnel.rest.converter.MandatConverter;
import com.faculte.mandatPersonnel.rest.converter.PersonnelConverter;
import com.faculte.mandatPersonnel.rest.converter.ProjetConverter;
import com.faculte.mandatPersonnel.rest.converter.ResponsabiliteConverter;
import com.faculte.mandatPersonnel.rest.converter.SousProjetConverter;
import com.faculte.mandatPersonnel.rest.converter.TypePersonnelConverter;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;
import com.faculte.mandatPersonnel.rest.vo.MandatVo;
import com.faculte.mandatPersonnel.rest.vo.PersonnelVo;
import com.faculte.mandatPersonnel.rest.vo.ProjetVo;
import com.faculte.mandatPersonnel.rest.vo.ResponsabiliteVo;
import com.faculte.mandatPersonnel.rest.vo.SousProjetVo;
import com.faculte.mandatPersonnel.rest.vo.TypePersonnelVo;
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
    private PersonnelService personnelService;

    @Autowired
    private TypePersonnelService typePersonnelService;

    @Autowired
    private ProjetService projetService;

    @Autowired
    private SousProjetService sousProjetService;

    @Autowired
    private ResponsabiliteService responsabiliteService;

    @Autowired
    private EntiteAdministratifService entiteAdministratifService;

    @Autowired
    private MandatService mandatService;

   
         //------------Debut---------------------Entite Administratif----------------------------------------------//
    
    @GetMapping("/entiteAdministratif/")
    public List<EntiteAdministratifVo> findAllEntite() {
        return new EntiteAdministratifConverter().toVo(entiteAdministratifService.findAll());
    }

    @GetMapping("/entiteAdministratif/{referenceEntiteAdministratif}")
    public EntiteAdministratifVo findByReferenceEntiteAdministratif(@PathVariable("referenceEntiteAdministratif") String referenceEntiteAdministratif) {
        return new EntiteAdministratifConverter().toVo(entiteAdministratifService.findByReferenceEntiteAdministratif(referenceEntiteAdministratif));
    }

    @PostMapping("/EntiteAdministartif/")
    public EntiteAdministratifVo createEntiteAdministratif(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
        EntiteAdministratifConverter entiteAdministratifConverter = new EntiteAdministratifConverter();
        EntiteAdministratif ea = entiteAdministratifConverter.toItem(entiteAdministratifVo);
        EntiteAdministratif entiteAdministratif = entiteAdministratifService.createEntiteAdministratif(ea);
        return new EntiteAdministratifConverter().toVo(entiteAdministratif);
    }

    @DeleteMapping("/delete/{referenceEntiteAdministratif}")
    public int deleteEntite(@PathVariable String referenceEntiteAdministratif) {
        return entiteAdministratifService.deleteEntite(referenceEntiteAdministratif);
    }
//   @PutMapping("/update/")
//    public int updateEntite(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
//        EntiteAdministratif e=EntiteAdministratifConverter().toItem(entiteAdministratifVo);
//        
//        return entiteAdministratifService.updateEntite(e);
//        
//    }

    //----------Fin-----------------------Entite Administratif----------------------------------------------//
    
    
    //------------Debut---------------------Projet----------------------------------------------//
    
    @GetMapping("/")
    public List<ProjetVo> findAll() {
        return new ProjetConverter().toVo(projetService.findAll());
    }
    
    @GetMapping("/libelleProjet/{libelleP}")
    public ProjetVo findByLibelleP(@PathVariable("libelleP") String libelleP) {
        return new ProjetConverter().toVo(projetService.findByLibelleP(libelleP));
    }

     @PostMapping("/projet/")
    public ProjetVo creerProjet(@RequestBody ProjetVo projetVo) {
        ProjetConverter projetConverter = new ProjetConverter();
        Projet myProjet = projetConverter.toItem(projetVo);
        Projet projet = projetService.creerProjet(myProjet);
        return new ProjetConverter().toVo(projet);
    }
    
    
    
    //------------Fin---------------------Projet----------------------------------------------//
    
    
    
    
    
    
    //------------Debut---------------------Sous Projet----------------------------------------------//
    
    @GetMapping("/sousProjet/")
    public List<SousProjetVo> findAllSousProjet() {
        return new SousProjetConverter().toVo(sousProjetService.findAll());
    }
    
    
    @GetMapping("/sousProjet/{referenceSousProjet}")
    public SousProjetVo findByReferenceSousProjet(@PathVariable("referenceSousProjet") String referenceSousProjet) {
        return new SousProjetConverter().toVo(sousProjetService.findByReferenceSousProjet(referenceSousProjet));
    }
    
     @GetMapping("/libelleP/{libelleP}/sous-projet")
    public List<SousProjetVo> findByProjetLibelleP(@PathVariable("libelleP") String libelleP) {
        final List<SousProjet> sousProjets = sousProjetService.findByProjetLibelleP(libelleP);
        return new SousProjetConverter().toVo(sousProjets);
    }

    
    //------------Fin---------------------Sous Projet----------------------------------------------//
    
    
    
    //------------Debut---------------------Mandat----------------------------------------------//
    
    @GetMapping("/mandat/")
    public List<MandatVo> findAllMandat() {
        return new MandatConverter().toVo(mandatService.findAll());
    }
    
    
     @PostMapping("/mandate/")
    public MandatVo creerMandat(@RequestBody MandatVo mandatVo) {
        MandatConverter mandatConverter = new MandatConverter();
        Mandat m = mandatConverter.toItem(mandatVo);
        Mandat mandat = mandatService.creerMandat(m);
        return new MandatConverter().toVo(mandat);
    }
    
    
    //------------Fin---------------------Mandat----------------------------------------------//

    
    
    //------------Debut---------------------Responsabilite----------------------------------------------//
    
   
    
    @GetMapping("/responsabilite/")
    public List<ResponsabiliteVo> findAllResponsabilite() {
        return new ResponsabiliteConverter().toVo(responsabiliteService.findAll());
    }
    
    
    @GetMapping("/Responsabilite/{poste}")
    public ResponsabiliteVo findByPoste(@PathVariable("poste") String poste) {
        return new ResponsabiliteConverter().toVo(responsabiliteService.findByPoste(poste));
    }

    
    
     @PostMapping("/Responsabilite/")
    public ResponsabiliteVo creerResponsabilite(@RequestBody ResponsabiliteVo responsabiliteVo) {
        ResponsabiliteConverter responsabiliteConverter = new ResponsabiliteConverter();
        Responsabilite resp = responsabiliteConverter.toItem(responsabiliteVo);
        Responsabilite responsabilite = responsabiliteService.creerResopnsabilite(resp);
        return new ResponsabiliteConverter().toVo(responsabilite);
    }

    
    //------------Fin---------------------Responsabilite----------------------------------------------//
    
    

    

   
    //------------Debut---------------------Personnel et type Personnel----------------------------------------------//
    @GetMapping("/personnel/")
    public List<PersonnelVo> findAllPersonnel() {
        return new PersonnelConverter().toVo(personnelService.findAll());
    }

    @GetMapping("/cin/{cin}")
    public PersonnelVo findByCin(@PathVariable("cin") String cin) {
        return new PersonnelConverter().toVo(personnelService.findByCin(cin));
    }

    @PostMapping("/")
    public PersonnelVo creerPersonnel(@RequestBody PersonnelVo personnelVo) {
        PersonnelConverter personnelConverter = new PersonnelConverter();
        Personnel p = personnelConverter.toItem(personnelVo);
        Personnel personnel = personnelService.creerPersonnel(p);
        return new PersonnelConverter().toVo(personnel);
    }

    @DeleteMapping("/personnel/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return personnelService.deleteByCin(cin);
    }

    
    @GetMapping("/libelle/{libelle}/")
    public TypePersonnelVo findByLibelle(@PathVariable("libelle") String libelle) {
        return new TypePersonnelConverter().toVo(typePersonnelService.findByLibelle(libelle));
    }
    //----------Fin-------------------Personnel et type Personnel----------------------------------------------//
   

   
   

    
    
    
    
    
    
    
    
    
    
    
    
    //-------------------------------------------------GETTER/SETTER---------------------------------------------------//
    
    
    public PersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public ProjetService getProjetService() {
        return projetService;
    }

    public void setProjetService(ProjetService projetService) {
        this.projetService = projetService;
    }

    public TypePersonnelService getTypePersonnelService() {
        return typePersonnelService;
    }

    public void setTypePersonnelService(TypePersonnelService typePersonnelService) {
        this.typePersonnelService = typePersonnelService;
    }

    public ResponsabiliteService getResponsabiliteService() {
        return responsabiliteService;
    }

    public void setResponsabiliteService(ResponsabiliteService responsabiliteService) {
        this.responsabiliteService = responsabiliteService;
    }

    public SousProjetService getSousProjetService() {
        return sousProjetService;
    }

    public void setSousProjetService(SousProjetService sousProjetService) {
        this.sousProjetService = sousProjetService;
    }

}
