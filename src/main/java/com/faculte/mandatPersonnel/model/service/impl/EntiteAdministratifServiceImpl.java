/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.model.dao.EntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.dao.TypeEntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import com.faculte.mandatPersonnel.model.service.TypeEntiteAdministratifService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.SearchUtil;

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
    private PersonnelService personnelService;

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
    public EntiteAdministratif findByChef(String cin) {
        return entiteAdministratifDao.findByChef(cin);
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
            Personnel p = personnelService.findByCin(entiteAdministratif.getChef().getCin());
            System.out.println("by");
            System.out.println("ha l personnel selectionne :" + p);
            if (sp != null && tp != null && p != null ) {
                ea.setSousProjet(sp);
                ea.setReferenceEntiteAdministratif(entiteAdministratif.getReferenceEntiteAdministratif());
                ea.setTypeEntiteAdministratif(tp);
                ea.setChef(p);
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
    public int updateEntite(EntiteAdministratif entite) {
    
          SousProjet sp = sousProjetService.findByReferenceSousProjet(entite.getSousProjet().getReferenceSousProjet());
          TypeEntiteAdministratif tp = typeEntiteAdministratifService.findByLibelle(entite.getTypeEntiteAdministratif().getLibelle());
          Personnel p = personnelService.findByCin(entite.getChef().getCin());
            entite.setSousProjet(sp);
            entite.setTypeEntiteAdministratif(tp);
            entite.setChef(p);
            entiteAdministratifDao.save(entite);
            return 1; 

    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EntiteAdministratif> chercherEntiteAdmin(String referenceEntiteAdministratif, String libelle, String referenceSousProjet) {

        String query = "select e from EntiteAdministratif e where 1=1";
        if (referenceEntiteAdministratif != null && !referenceEntiteAdministratif.equals("")) {
            query += SearchUtil.addConstraint("e", "referenceEntiteAdministratif", "LIKE", referenceEntiteAdministratif);
        }

        if (libelle != null && !libelle.equals("")) {

            query += SearchUtil.addConstraint("e", "typeEntiteAdministratif.libelle", "LIKE", libelle);

        }
        if (referenceSousProjet != null && !referenceSousProjet.equals("")) {
            query += SearchUtil.addConstraint("e", "sousProjet.referenceSousProjet", "LIKE", referenceSousProjet);

        }
        System.out.println("query --->" + query);
        return entityManager.createQuery(query).getResultList();
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
