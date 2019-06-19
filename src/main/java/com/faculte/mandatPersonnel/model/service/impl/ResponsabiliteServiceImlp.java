/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.model.dao.ResponsabiliteDao;
import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class ResponsabiliteServiceImlp implements ResponsabiliteService {

    @Autowired
    private ResponsabiliteDao responsabiliteDao;
    
    @Autowired
    private ResponsabiliteService responsabiliteService;

    @Override
    public List<Responsabilite> findAll() {
        return responsabiliteDao.findAll();
    }

    @Override
    public Responsabilite findByReferenceResponsabilite(String referenceResponsabilite) {
        return responsabiliteDao.findByReferenceResponsabilite(referenceResponsabilite);
    }

    @Override
    public int creerResopnsabilite(Responsabilite responsabilite) {
        Responsabilite r = findByReferenceResponsabilite(responsabilite.getReferenceResponsabilite());
        if (r != null) {
            return -1;
        } else {
            r = new Responsabilite();
            r.setReferenceResponsabilite(responsabilite.getReferenceResponsabilite());
            responsabiliteDao.save(r);
            return 1;
        }

    }

        @Override
    public int updateResponsabilite(Responsabilite responsabilite) {
        responsabiliteDao.save(responsabilite);
        return 1;
    }

    
       @Override
    public int deleteByReferenceResponsabilite(String referenceResponsabilite) {
         Responsabilite r = responsabiliteService.findByReferenceResponsabilite(referenceResponsabilite);
          if (r == null) {
            return -1;
        } else { 
            responsabiliteDao.delete(r);
            return 1;
        }
    }
    public ResponsabiliteDao getResponsabiliteDao() {
        return responsabiliteDao;
    }

    public void setResponsabiliteDao(ResponsabiliteDao responsabiliteDao) {
        this.responsabiliteDao = responsabiliteDao;
    }

 


}
