/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.Responsabilite;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface MandatService {

    public Mandat findByPersonnelCin(String cin);
    public Mandat creerMandat(Mandat mandat);
    public List<Mandat> findAll();

}
