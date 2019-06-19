/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.SousProjet;
import java.util.List;


/**
 *
 * @author abdou
 */
public interface SousProjetService {

    public SousProjet findByReferenceSousProjet(String referenceSousProjet);
    public List<SousProjet> findByProjetLibelleP(String libelleP);
    public int creerSousProjet(SousProjet sousProjet,String projet);
    public List<SousProjet> findAll();
    public int deleteByReferenceSousProjet(String referenceSousProjet);
    public int deleteSousProjetById(Long id);
 //  public List<SousProjet> findByCriteria(String libelleP);
}
