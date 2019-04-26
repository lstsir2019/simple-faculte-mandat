/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.TypePersonnel;
import com.faculte.mandatPersonnel.model.dao.PersonnelDao;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.model.service.TypePersonnelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    private PersonnelDao personnelDao;

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private TypePersonnelService typePersonnelService;

    @Override
    public List<Personnel> findAll() {
        return personnelDao.findAll();
    }

    @Override
    public Personnel findByCin(String cin) {
        return personnelDao.findByCin(cin);
    }

    @Override
    public Personnel creerPersonnel(Personnel personnel) {
        Personnel p = findByCin(personnel.getCin());
        if (p != null) {
            return null;
        } else {
            // TypePersonnel tp =typePersonnelService.createTypePersonnel(personnel.getTypePersonnel().getLibelle());
            TypePersonnel tp = typePersonnelService.findByLibelle(personnel.getTypePersonnel().getLibelle());
            if (tp != null) {
                personnel.setTypePersonnel(tp);
                System.out.println(tp);
                personnelDao.save(personnel);

                return personnel;
            } else {
                return null;
            }

        }
    }

    @Override
    public int deleteByCin(String cin) {
        Personnel p = personnelService.findByCin(cin);
        if (p == null) {
            return -1;
        } else {
            personnelDao.delete(p);
            return 1;
        }
    }

    public PersonnelDao getPersonnelDao() {
        return personnelDao;
    }

    public void setPersonnelDao(PersonnelDao personnelDao) {
        this.personnelDao = personnelDao;
    }

    public TypePersonnelService getTypePersonnelService() {
        return typePersonnelService;
    }

    public void setTypePersonnelService(TypePersonnelService typePersonnelService) {
        this.typePersonnelService = typePersonnelService;
    }

    public PersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

}
