/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface EntiteAdministratifService {

    public int createEntiteAdministratif(EntiteAdministratif entiteAdministratif);

    public EntiteAdministratif findByReferenceEntiteAdministratif(String referenceEntiteAdministratif);

    public List<EntiteAdministratif> findAll();
    //public void deleteByReferenceEntiteAdministratif(String referenceEntiteAdministratif);

    public int deleteEntite(String referenceEntiteAdministratif);

    public int updateEntite(EntiteAdministratif entite);

    public List<EntiteAdministratif> findByTypeEntiteAdministratifReference(int reference);

    public EntiteAdministratif findByTypeEntiteAdministratifLibelle(String libelle);

    public EntiteAdministratif findByreferenceEntiteAdministratifAndTypeEntiteAdministratifReference(String refEnti, int refType);

    public List<EntiteAdministratif> chercherEntiteAdmin(String referenceEntiteAdministratif, String libelle, String referenceSousProjet);

     public EntiteAdministratif findByChef(String cin);
}
