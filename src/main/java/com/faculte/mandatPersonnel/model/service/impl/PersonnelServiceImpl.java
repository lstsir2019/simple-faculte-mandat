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
    public Personnel findByTypePersonnelLibelle(String libelle) {
        return personnelDao.findByTypePersonnelLibelle(libelle);
    }

    @Override
    public int creerPersonnel(Personnel personnel) {
        Personnel p = findByCin(personnel.getCin());
        if (p != null) {
            return -1;
        } else {
            // TypePersonnel tp =typePersonnelService.createTypePersonnel(personnel.getTypePersonnel().getLibelle());
            TypePersonnel tp = typePersonnelService.findByLibelle(personnel.getTypePersonnel().getLibelle());
            if (tp != null) {
                personnel.setTypePersonnel(tp);
                System.out.println(tp);
                personnelDao.save(personnel);

                return 1;
            } else {
                return -2;
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

    @Override
    public int updatePersonnel(Personnel personnel) {
        System.out.println("personnel :"+personnel.getCin()+" "+personnel.getId());
            TypePersonnel tp = typePersonnelService.findByLibelle(personnel.getTypePersonnel().getLibelle());
            System.out.println(" type :"+personnel.getTypePersonnel().getLibelle());
            personnel.setTypePersonnel(tp);
            personnelDao.save(personnel);
            System.out.println("update personnel======> " + personnel.getNom());
            return 1; 

    }
    
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Personnel> chercherPersonnel(String cin, String libelle) {

        String query = "select p from Personnel p where 1=1";
        if (cin != null && !cin.equals("")) {
            query += SearchUtil.addConstraint("p", "cin", "LIKE", cin);
        }
        if (libelle != null&& !libelle.equals("")) {
            query += SearchUtil.addConstraint("p", "typePersonnel.libelle", "LIKE", libelle);

        }
        System.out.println("query --->" + query);
        return entityManager.createQuery(query).getResultList();
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
