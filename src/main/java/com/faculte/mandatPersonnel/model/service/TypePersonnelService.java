/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;


import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.TypePersonnel;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface TypePersonnelService {
    public TypePersonnel findByPersonnel(Personnel personnel); 
    public TypePersonnel createTypePersonnel(String libelle);
    public TypePersonnel findByLibelle(String libelle);
    public List<TypePersonnel> findAll();
    public int updateTypePersonnel(TypePersonnel typePersonnel);
    public int findById(Long id);
}

