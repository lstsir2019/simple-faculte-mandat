/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.TypeEntiteAdministratif;
import java.util.List;




/**
 *
 * @author abdou
 */
public interface TypeEntiteAdministratifService {
   public TypeEntiteAdministratif findByLibelle(String libelle);
   public TypeEntiteAdministratif createTypeEntiteAdministratif(String libelle,int reference);
   public List<TypeEntiteAdministratif> findAll();
    public TypeEntiteAdministratif findByReference(int reference);
}

