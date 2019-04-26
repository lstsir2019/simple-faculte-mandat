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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    @Override
    public Mandat findByPersonnelCin(String cin) {
        return mandatDao.findByPersonnelCin(cin);
    }

    @Override
    public Mandat creerMandat(Mandat mandat) {
        Personnel personnel = personnelService.findByCin(mandat.getPersonnel().getCin());
        EntiteAdministratif entite = entiteAdministratifService.findByReferenceEntiteAdministratif(mandat.getEntiteAdministratif().getReferenceEntiteAdministratif());
        Responsabilite responsabilite = responsabiliteService.findByPoste(mandat.getResponsabilite().getPoste());
        mandat.setPersonnel(personnel);
        mandat.setEntiteAdministratif(entite);
        mandat.setResponsabilite(responsabilite);
        mandatDao.save(mandat);
        return mandat;

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
