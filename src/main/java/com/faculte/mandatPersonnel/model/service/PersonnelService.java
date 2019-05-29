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
public interface PersonnelService {

    public Personnel findByCin(String cin);

    public int creerPersonnel(Personnel personnel);

    public int deleteByCin(String cin);

    public List<Personnel> findAll();

    public int updatePersonnel(Personnel personnel);

    public Personnel findByTypePersonnelLibelle(String libelle);
    
    public  List<Personnel>  chercherPersonnel(String cin , String libelle);

}
