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
    public Responsabilite findByPoste(String poste) {
        return responsabiliteDao.findByPoste(poste);
    }

    @Override
    public int creerResopnsabilite(Responsabilite responsabilite) {
        Responsabilite r = findByPoste(responsabilite.getPoste());
        if (r != null) {
            return -1;
        } else {
            r = new Responsabilite();
            r.setPoste(responsabilite.getPoste());
            responsabiliteDao.save(r);
            return 1;
        }

    }

    public ResponsabiliteDao getResponsabiliteDao() {
        return responsabiliteDao;
    }

    public void setResponsabiliteDao(ResponsabiliteDao responsabiliteDao) {
        this.responsabiliteDao = responsabiliteDao;
    }

    @Override
    public int deleteByPoste(String poste) {
         Responsabilite r = responsabiliteService.findByPoste(poste);
          if (r == null) {
            return -1;
        } else { 
            responsabiliteDao.delete(r);
            return 1;
        }
    }

}
