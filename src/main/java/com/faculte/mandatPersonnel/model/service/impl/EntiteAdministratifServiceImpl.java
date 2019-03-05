/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.model.dao.EntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
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

    @Override
    public EntiteAdministratif findByEntite(String entite) {
        return entiteAdministratifDao.findByEntite(entite);
    }
    
    @Override
    public EntiteAdministratif createEntiteAdministratif(String entite) {
        EntiteAdministratif ea = findByEntite(entite);
         if (ea != null) {
            return null;
        } else {
            ea = new EntiteAdministratif();
            ea.setEntite(entite);
            entiteAdministratifDao.save(ea);
            return ea;
        }
    }

   
}
