/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.SousProjet;


/**
 *
 * @author abdou
 */
public interface SousProjetService {

    public SousProjet findByLibelleSP(String libelleSP);
    //public List<SousProjet> findByProjet(Projet projet);
    public int creerSousProjet(SousProjet sousProjet);
}
