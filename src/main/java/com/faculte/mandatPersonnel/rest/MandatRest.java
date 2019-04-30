/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest;


import com.faculte.mandatPersonnel.model.service.ProjetService;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.Projet;
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
    public int createEntiteAdministratif(@RequestBody EntiteAdministratifVo entiteAdministratifVo) {
        return entiteAdministratifService.createEntiteAdministratif(new EntiteAdministratifConverter().toItem(entiteAdministratifVo));
    }

    @DeleteMapping("/deleteEa/{referenceEntiteAdministratif}")
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

    @DeleteMapping("/deleteP/{libelleP}")
    public int deleteProjet(@PathVariable String libelleP) {
        return projetService.deleteByLibelleP(libelleP);
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

//    @DeleteMapping("/deleteSp/{referenceSousProjet}")
//    public int deleteSousProjet(@PathVariable String referenceSousProjet) {
//        return sousProjetService.deleteByReferenceSousProjet(referenceSousProjet);
//    }
    @DeleteMapping("/deleteSpById/{id}")
    public int deleteSousProjetById(@PathVariable("id") Long id) {
        return sousProjetService.deleteSousProjetById(id);
    }

    //------------Fin---------------------Sous Projet----------------------------------------------//
    //------------Debut---------------------Mandat----------------------------------------------//
    @GetMapping("/mandat/")
    public List<MandatVo> findAllMandat() {
        return new MandatConverter().toVo(mandatService.findAll());
    }

    @GetMapping("/MandatCin/{cin}")
    public MandatVo findByMandatPersonnelCin(@PathVariable("cin") String cin) {
        return new MandatConverter().toVo(mandatService.findByPersonnelCin(cin));
    }

    @PostMapping("/mandate/")
    public int creerMandat(@RequestBody MandatVo mandatVo) {
        return mandatService.creerMandat(new MandatConverter().toItem(mandatVo));

    }

    @DeleteMapping("/deleteMandat/{cin}")
    public int deleteMandat(@PathVariable String cin) {
        return mandatService.deleteByMandatPersonnelCin(cin);
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
    public int creerResponsabilite(@RequestBody ResponsabiliteVo responsabiliteVo) {
        return responsabiliteService.creerResopnsabilite(new ResponsabiliteConverter().toItem(responsabiliteVo));
    }

    @DeleteMapping("/deletePoste/{poste}")
    public int deleteByPoste(@PathVariable String poste) {
        return responsabiliteService.deleteByPoste(poste);
    }

    //------------Fin---------------------Responsabilite----------------------------------------------//
    //------------Debut---------------------Personnel et type Personnel----------------------------------------------//
    @GetMapping("/personnel/")
    public List<PersonnelVo> findAllPersonnel() {
        return new PersonnelConverter().toVo(personnelService.findAll());
    }

    @GetMapping("/typePersonnel/")
    public List<TypePersonnelVo> findAllTypePersonnel() {
        return new TypePersonnelConverter().toVo(typePersonnelService.findAll());
    }

    @GetMapping("/cin/{cin}")
    public PersonnelVo findByCin(@PathVariable("cin") String cin) {
        return new PersonnelConverter().toVo(personnelService.findByCin(cin));
    }

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

    @GetMapping("/libelle/{libelle}/")
    public TypePersonnelVo findByLibelle(@PathVariable("libelle") String libelle) {
        return new TypePersonnelConverter().toVo(typePersonnelService.findByLibelle(libelle));
    }

    @DeleteMapping("/deletePersonnel/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return personnelService.deleteByCin(cin);
    }

    @PutMapping("/")
    public PersonnelVo updatePersonnel(@RequestBody PersonnelVo personnelVo) {
        PersonnelConverter personnelConverter = new PersonnelConverter();
        Personnel p = personnelConverter.toItem(personnelVo);
        Personnel personnel = personnelService.updatePersonnel(p);
        return new PersonnelConverter().toVo(personnel);

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
