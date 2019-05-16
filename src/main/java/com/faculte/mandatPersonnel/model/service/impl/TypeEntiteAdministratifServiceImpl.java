/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import com.faculte.mandatPersonnel.model.dao.TypeEntiteAdministratifDao;
import com.faculte.mandatPersonnel.model.service.TypeEntiteAdministratifService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class TypeEntiteAdministratifServiceImpl implements TypeEntiteAdministratifService {

    @Autowired
    private TypeEntiteAdministratifDao typeEntiteAdministratifDao;

    @Override
    public List<TypeEntiteAdministratif> findAll() {
        return typeEntiteAdministratifDao.findAll();
    }

    @Override
    public TypeEntiteAdministratif findByLibelle(String libelle) {
        System.out.println("hani");
        return typeEntiteAdministratifDao.findByLibelle(libelle);
    }

    @Override
    public TypeEntiteAdministratif findByReference(int reference) {
        return typeEntiteAdministratifDao.findByReference(reference);
    }
    @Override
    public TypeEntiteAdministratif createTypeEntiteAdministratif(String libelle, int reference) {
        TypeEntiteAdministratif t = findByLibelle(libelle);
        if (t != null) {
            return null;
        } else {
            TypeEntiteAdministratif typeEntiteAdministratif = new TypeEntiteAdministratif();
            typeEntiteAdministratif.setLibelle(libelle);
            typeEntiteAdministratif.setReference(reference);
            typeEntiteAdministratifDao.save(typeEntiteAdministratif);
            return typeEntiteAdministratif;
        }
    }

    

}
