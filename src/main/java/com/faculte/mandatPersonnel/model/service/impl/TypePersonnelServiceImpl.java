/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.TypePersonnel;
import com.faculte.mandatPersonnel.model.dao.TypePersonnelDao;
import com.faculte.mandatPersonnel.model.service.TypePersonnelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 *
 * @author abdou
 */
@Service
public class TypePersonnelServiceImpl implements TypePersonnelService{

    @Autowired
     private TypePersonnelDao typePersonnelDao;
 
     @Override
    public List<TypePersonnel> findAll() {
        return typePersonnelDao.findAll();
    }
    
    @Override
    public TypePersonnel findByPersonnel(Personnel personnel) {
        return typePersonnelDao.findByPersonnel(personnel);
    }
      @Override
    public TypePersonnel findByLibelle(String libelle) {
        return typePersonnelDao.findByLibelle(libelle);
    }
    @Override
    public TypePersonnel createTypePersonnel(String libelle){
        TypePersonnel p = findByLibelle(libelle);
        if(p!= null){
            return null;
        }
        else{
        TypePersonnel typePersonnel = new TypePersonnel();
        typePersonnel.setLibelle(libelle);
        typePersonnelDao.save(typePersonnel);
        return typePersonnel;
    }
        
    }

    @Override
    public int updateTypePersonnel(TypePersonnel typePersonnel) {
         int tp = findById(typePersonnel.getId());
        if (tp == 0) {
            return -1;
        } else {
            System.out.println(typePersonnel.getLibelle());
            typePersonnel.setId(typePersonnel.getId());
            typePersonnel.setLibelle(typePersonnel.getLibelle());
            typePersonnelDao.save(typePersonnel);
            return  1;
        }
        
    }

    @Override
    public int findById(Long id) {
        boolean tp = typePersonnelDao.existsById(id);
        if (!tp) {
            return -1;
        } else {
            typePersonnelDao.getOne(id);
            return 1;
        }
    }
    }

  
    
   

  


