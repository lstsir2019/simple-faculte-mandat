/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.model.dao.MandatDao;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.model.service.MandatService;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.SearchUtil;

/**
 *
 * @author abdou
 */
@Service
public class MandatServiceImpl implements MandatService {

    @Autowired
    private MandatDao mandatDao;

    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private EntiteAdministratifService entiteAdministratifService;
    @Autowired
    private ResponsabiliteService responsabiliteService;

    @Autowired
    private MandatService mandatService;

    @Override
    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    @Override
    public Mandat findByPersonnelCin(String cin) {
        return mandatDao.findByPersonnelCin(cin);
    }

    @Override
    public List<Mandat> findByEntiteAdministratifReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        return mandatDao.findByEntiteAdministratifReferenceEntiteAdministratif(referenceEntiteAdministratif);
    }

    @Override
    public List<Mandat> findByResponsabiliteReferenceResponsabilite(String referenceResponsabilite) {
        return mandatDao.findByResponsabiliteReferenceResponsabilite(referenceResponsabilite);
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Mandat> chercherMandat(String cin, String referenceEntiteAdministratif, String referenceResponsabilite) {

        String query = "select m from Mandat m where 1=1";
        if (cin != null && !cin.equals("")) {
            query += SearchUtil.addConstraint("m", "personnel.cin", "LIKE", cin);
        }
        if (referenceEntiteAdministratif != null && !referenceEntiteAdministratif.equals("")) {
            query += SearchUtil.addConstraint("m", "entiteAdministratif.referenceEntiteAdministratif", "LIKE", referenceEntiteAdministratif);
        }
        if (referenceResponsabilite != null && !referenceResponsabilite.equals("")) {
            query += SearchUtil.addConstraint("m", "responsabilite.referenceResponsabilite", "LIKE", referenceResponsabilite);
        }
        System.out.println("query --->" + query);
        return entityManager.createQuery(query).getResultList();
    }

    

    @Override
    public int creerMandat(Mandat mandat) {
        Personnel personnel = personnelService.findByCin(mandat.getPersonnel().getCin());
//        if (mandat.getPersonnel().getCin() == null) {
//            return -1;
//        }
        EntiteAdministratif entite = entiteAdministratifService.findByReferenceEntiteAdministratif(mandat.getEntiteAdministratif().getReferenceEntiteAdministratif());
//        if (mandat.getEntiteAdministratif().getReferenceEntiteAdministratif() == null) {
//            return -2;
//        }
        Responsabilite responsabilite = responsabiliteService.findByReferenceResponsabilite(mandat.getResponsabilite().getReferenceResponsabilite());
//        if (mandat.getResponsabilite().getPoste() == null) {
//            return -3;
//        } 
//        else {
        mandat.setPersonnel(personnel);
        mandat.setEntiteAdministratif(entite);
        mandat.setResponsabilite(responsabilite);
        mandatDao.save(mandat);
        return 1;

//        }
    }

    @Override
    public int deleteByMandatPersonnelCin(String cin) {
        Mandat m = mandatService.findByPersonnelCin(cin);
        if (m == null) {
            return -1;
        } else {
            mandatDao.delete(m);
            return 1;
        }

    }

    public MandatDao getMandatDao() {
        return mandatDao;
    }

    public void setMandatDao(MandatDao mandatDao) {
        this.mandatDao = mandatDao;
    }

    public PersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    public EntiteAdministratifService getEntiteAdministratifService() {
        return entiteAdministratifService;
    }

    public void setEntiteAdministratifService(EntiteAdministratifService entiteAdministratifService) {
        this.entiteAdministratifService = entiteAdministratifService;
    }

    public ResponsabiliteService getResponsabiliteService() {
        return responsabiliteService;
    }

    public void setResponsabiliteService(ResponsabiliteService responsabiliteService) {
        this.responsabiliteService = responsabiliteService;
    }

}
