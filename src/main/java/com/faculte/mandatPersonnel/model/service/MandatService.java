/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.Mandat;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface MandatService {

    public int creerMandat(Mandat mandat);
    public int deleteByMandatPersonnelCin(String cin);
    public List<Mandat> findAll();
    public Mandat findByPersonnelCin(String cin);
   public List<Mandat> findByEntiteAdministratifReferenceEntiteAdministratif(String referenceEntiteAdministratif);
    public List<Mandat> findByResponsabiliteReferenceResponsabilite(String referenceResponsabilite);
    public List<Mandat> findByCriteria(String cin,String referenceEntiteAdministratif,String poste);
}
