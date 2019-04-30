/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.Responsabilite;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface ResponsabiliteService {
    public int creerResopnsabilite(Responsabilite responsabilite);
    public Responsabilite findByPoste(String poste);
    public List<Responsabilite> findAll();
    public int deleteByPoste(String poste);
}
