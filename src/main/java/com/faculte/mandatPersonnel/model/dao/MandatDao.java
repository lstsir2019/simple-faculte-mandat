/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.dao;

import com.faculte.mandatPersonnel.bean.Mandat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdou
 */
@Repository
public interface MandatDao extends JpaRepository<Mandat, Long>{
    
    
  //  public Mandat findByMandatDateDebutMandatPersonnelCin(String cin);
   // public Mandat findByMandatEntiteAdministratifEntite(String entite);
   // public Mandat findByMandatResponsabilitePoste(String poste);
   
}

