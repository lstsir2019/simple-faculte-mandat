/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.model.dao.EntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.dao.TypeEntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.model.service.TypeEntiteAdministratifService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class EntiteAdministratifServiceImpl implements EntiteAdministratifService {

    @Autowired
    private EntiteAdministratifDao entiteAdministratifDao;

    @Autowired
    private TypeEntiteAdministratifDao typeEntiteAdministratifDao;

    @Autowired
    private SousProjetService sousProjetService;

    @Autowired
    private TypeEntiteAdministratifService typeEntiteAdministratifService;
//    @Override
//    public void deleteByReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
//        entiteAdministratifDao.deleteByReferenceEntiteAdministratif(referenceEntiteAdministratif);
//    }

    @Override
    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifDao.findAll();
    }

    @Override
    public EntiteAdministratif findByReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        return entiteAdministratifDao.findByReferenceEntiteAdministratif(referenceEntiteAdministratif);
    }

    @Override
    public int createEntiteAdministratif(EntiteAdministratif entiteAdministratif) {
        EntiteAdministratif ea = findByReferenceEntiteAdministratif(entiteAdministratif.getReferenceEntiteAdministratif());
        if (ea != null) {
            return -1;
        } else {
            ea = new EntiteAdministratif();
            SousProjet sp = sousProjetService.findByReferenceSousProjet(entiteAdministratif.getSousProjet().getReferenceSousProjet());
            System.out.println("hi");
            System.out.println("libelle : " + entiteAdministratif.getTypeEntiteAdministratif().getLibelle());
            TypeEntiteAdministratif tp = typeEntiteAdministratifService.findByLibelle(entiteAdministratif.getTypeEntiteAdministratif().getLibelle());
            System.out.println("by");
            if (sp != null && tp != null) {
                ea.setSousProjet(sp);
                ea.setReferenceEntiteAdministratif(entiteAdministratif.getReferenceEntiteAdministratif());
                ea.setTypeEntiteAdministratif(tp);
                entiteAdministratifDao.save(ea);
                return 1;
            } else {
                return -2;
            }

        }
    }

    @Override
    public int deleteEntite(String referenceEntiteAdministratif) {
        EntiteAdministratif e = findByReferenceEntiteAdministratif(referenceEntiteAdministratif);
        if (e == null) {
            return -1;
        } else {
            entiteAdministratifDao.delete(e);
            return 1;
        }
    }

    @Override
    @Transactional
    public int updateEntite(EntiteAdministratif entite) {
        EntiteAdministratif e = findByReferenceEntiteAdministratif(entite.getReferenceEntiteAdministratif());
        if (e == null) {
            return -1;
        } else {
            entiteAdministratifDao.save(e);
            return 1;
        }
    }

    @Override
    public EntiteAdministratif findByreferenceEntiteAdministratifAndTypeEntiteAdministratifReference(String refEnti, int refType) {
        return entiteAdministratifDao.findByreferenceEntiteAdministratifAndTypeEntiteAdministratifReference(refEnti, refType);
    }

    @Override
    public EntiteAdministratif findByTypeEntiteAdministratifLibelle(String libelle) {
        return entiteAdministratifDao.findByTypeEntiteAdministratifLibelle(libelle);
    }

    @Override
    public List<EntiteAdministratif> findByTypeEntiteAdministratifReference(int reference) {
        return entiteAdministratifDao.findByTypeEntiteAdministratifReference(reference);
    }

    public EntiteAdministratifDao getEntiteAdministratifDao() {
        return entiteAdministratifDao;
    }

    public void setEntiteAdministratifDao(EntiteAdministratifDao entiteAdministratifDao) {
        this.entiteAdministratifDao = entiteAdministratifDao;
    }

    public TypeEntiteAdministratifDao getTypeEntiteAdministratifDao() {
        return typeEntiteAdministratifDao;
    }

    public void setTypeEntiteAdministratifDao(TypeEntiteAdministratifDao typeEntiteAdministratifDao) {
        this.typeEntiteAdministratifDao = typeEntiteAdministratifDao;
    }

    public SousProjetService getSousProjetService() {
        return sousProjetService;
    }

    public void setSousProjetService(SousProjetService sousProjetService) {
        this.sousProjetService = sousProjetService;
    }

    public TypeEntiteAdministratifService getTypeEntiteAdministratifService() {
        return typeEntiteAdministratifService;
    }

    public void setTypeEntiteAdministratifService(TypeEntiteAdministratifService typeEntiteAdministratifService) {
        this.typeEntiteAdministratifService = typeEntiteAdministratifService;
    }

}
